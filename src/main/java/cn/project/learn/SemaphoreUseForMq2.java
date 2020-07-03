package cn.project.learn;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量在MQ消息处理方案的应用2
 */
public class SemaphoreUseForMq2 {
    private Executor taskPool = Executors.newFixedThreadPool(10);

    /* 初始化与Worker线程数量相同的令牌 */
    private Semaphore permits = new Semaphore(10);


    private void exec() throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            // 获取令牌，如果获取不到则block，直到有worker线程归还
            permits.acquire();
            taskPool.execute(new WorkerThread(permits));
        }

    }

    /**
     * 任务线程
     */
    private class WorkerThread implements Runnable {

        private Semaphore permits;

        public WorkerThread(Semaphore permits) {
            this.permits = permits;
        }

        public void run() {
            try {
                // do sth
            } catch (Exception e) {
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
