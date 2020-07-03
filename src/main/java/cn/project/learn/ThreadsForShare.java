package cn.project.learn;

/**
 * 多线程操作共享变量的方式
 */
public class ThreadsForShare {
    public void test(){

    }
}

/**
 * 1. 每个线程执行逻辑相同，可以在创建任务时，将变量设置到任务上。
 */
class ThreadsForShareTask1 implements Runnable{

    private int ticket = 5;

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            synchronized (this){
                try{
                    Thread.sleep(30);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("卖票");
            }
        }
    }
}

/**
 * 2.1 每个线程执行逻辑不同，
 *          定义共享变量，将线程安全反转给共享变量，
 *          定义不同的任务类，将共享变量其传递给每个任务。
 */
class ShareDataForTask2_1{
    private int j = 0;
    public synchronized void increment(){
        j++;
    }

    public synchronized void decrement(){
        j--;
    }
}
class ThreadsForShareTask2_1_1 implements Runnable{

    private ShareDataForTask2_1 shareData;

    public ThreadsForShareTask2_1_1(ShareDataForTask2_1 shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        shareData.decrement();
    }
}
class ThreadsForShareTask2_1_2 implements Runnable{

    public ThreadsForShareTask2_1_2(ShareDataForTask2_1 shareData) {
        this.shareData = shareData;
    }

    private ShareDataForTask2_1 shareData;

    @Override
    public void run() {
        shareData.increment();
    }
}

/**
 * 2.2 每个线程执行逻辑不同，
 *          将任务定义为某个类的内部类，
 *          共享变量作为外部类中的成员遍历
 *
 */

class SalesHandler {
    private int j;
    private synchronized void inc(){
        j++;
        System.out.println(Thread.currentThread().getName()+"-inc:"+j);
    }

    private synchronized void dec(){
        j--;
        System.out.println(Thread.currentThread().getName()+"-dec:"+j);
    }
    class Inc implements Runnable{      //线程1
        public void run(){
            for(int i=0;i<5;i++){
                inc();
            }
        }
    }

    class Dec implements Runnable{      //线程2
        public void run(){
            for(int i=0;i<5;i++){
                dec();
            }
        }
    }
}

/**
 * 3.别忘了static关键字
 */