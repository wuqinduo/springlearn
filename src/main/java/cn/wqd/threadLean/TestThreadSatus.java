package cn.wqd.threadLean;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class TestThreadSatus {

    final static Object lockObject = new Object();
    public static void main(String[] args) {
        try{
            Thread parkThead = new Thread(null,() -> {
                System.out.println("这是LockSupport工具演示");
                LockSupport.park();
            },"LockSupport工具等待演示线程");
            parkThead.start();

            Thread waitThead = new Thread(null,()-> {
                synchronized (lockObject){
                    System.out.println("这是同步锁等待演示1");
                    try{
                        lockObject.wait();
                        Thread.sleep(10000);
                        System.out.println("我有获得锁了");
                    }catch (Exception e){

                    }
                }
            },"同步锁等待演示线程1");
            waitThead.start();

            Thread waitThead2 = new Thread(null,()-> {
                synchronized (lockObject){
                    System.out.println("这是同步锁等待演示2");
                    try{
                        for (int i=0;i<100000;i++){

                        }
                       lockObject.notifyAll();
                        System.out.println("我结束了 你们抢锁吧");
                    }catch (Exception e){

                    }
                }
            },"同步锁等待演示线程2");
            waitThead2.start();


            Thread waitThead3 = new Thread(null,()-> {
                synchronized (lockObject){
                    System.out.println("这是同步锁等待演示3");
                    try{
                        lockObject.wait();
                        Thread.sleep(10000);
                        System.out.println("我有获得锁了");
                    }catch (Exception e){

                    }
                }
            },"同步锁等待演示线程3");
            waitThead3.start();

            TimeUnit.SECONDS.sleep(100000);
        }catch (Exception e){

        }


    }


}
class ThreadA extends Thread{
    public ThreadA(String name) {
        super(name);
    }
    public void run() {
        synchronized (this) {
            try {
                Thread.sleep(1000); //  使当前线阻塞 1 s，确保主程序的 t1.wait(); 执行之后再执行 notify()
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" call notify()");
            // 唤醒当前的wait线程
            this.notify();
        }
    }
}
