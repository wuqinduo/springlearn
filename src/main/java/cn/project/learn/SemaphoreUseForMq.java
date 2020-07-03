package cn.project.learn;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 信号量在MQ消息处理方案的应用1
 *
 * 问题描述：
 *          Q的生产者生产消息能力是消费者的数倍。 如果不能尽快消费完会导致队列中的消息随着时间的推移会越积越多
 *
 *          在不增加节点的前提下，快速消费。
 *
 * 问题的分析：（每写一段代码时，多考虑一步，心细一些）
 *
 *          （1）使用线程池
 *              只用线程池就可以了吗？
 *                  * 当任务量大时，达到quue的阈值，触发拒绝策略，容易丢失任务。
 *                  * 我们不能把queue设置太大，会出现任务堆积在JVM中。
 *
 * 问题的本质：
 *          既要用线程池（任务快速消费），又要任务丢失。--关键就落在了对【任务速率的控制,包装工作线程处于工作状态】
 *
 * 问题的解决：
 *          主从线程模型。主负责按一定速率向从提交任务
 *
 *          1.初始化与Worker线程数量相同的令牌
 *          2.主线程向线程池提交任务时尝试从令牌桶获取一个令牌，如果令牌为空则block阻塞
 *          3.把令牌传入worker线程，worker线程执行完成后，调用relaease归还令牌
 */
public class SemaphoreUseForMq {

    private static int workerCount = 10;

    private Semaphore permits = new Semaphore(workerCount);

    private void exec() throws InterruptedException{
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(workerCount,workerCount,60, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(10));//等10个线程都启动后，之后是从队列里取数据

        for (int i=0;i<100;i++){
            permits.acquire();
            threadPoolExecutor.submit(new WorkderThread(permits));
        }
    }

    private class  WorkderThread implements Runnable{
        private Semaphore permits;

        public WorkderThread(Semaphore permits) {
            this.permits = permits;
        }

        @Override
        public void run() {
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " is running...");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                if (permits != null) {
                    // 释放令牌
                    permits.release();
                }
            }
        }
    }


}
