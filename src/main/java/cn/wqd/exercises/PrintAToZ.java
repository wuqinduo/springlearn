package cn.wqd.exercises;

/**
 * 1. 无锁解决
 * 2. object竞争锁方式.
 *    https://mp.weixin.qq.com/s/DcB485_A4TP4pxVJKaTSPg
 * 3. Condtion 1.5以后:代替传统的Object 的wait(),notify() 实现的线程协作,更加安全高效
 *      Conditon中的await()对应Object的wait()；
 *      Condition中的signal()对应Object的notify()；
 *      Condition中的signalAll()对应Object的notifyAll()。
 *      https://blog.csdn.net/hemeinvyiqiluoben/article/details/82990817
 *
 */
public class PrintAToZ {
    //下个线程的线程标志(线程间可见)
    public static volatile String nextThread = "yuanyin";
    //数组index的位置,线程间可见
    public  static volatile int index= 0;

    public static final char[] words = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                      'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static void main(String[] args) {
        YuanThread yuanThread = new YuanThread();
        FuThread fuThread = new FuThread();
        new Thread(yuanThread).start();
        new Thread(fuThread).start();
    }


    public static boolean isYuanying(char c){
        char[] yuanArray = {'a','e','i','o','u'};
        for (int i=0;i<yuanArray.length;i++){
            if(yuanArray[i]==c){
                return true;
            }
        }
        return false;
    }

    //静态内部类,解决多继承问,内部类可以直接使用外部类的静态变量
    protected static class YuanThread implements Runnable{
        private String threadName="yuanyin";
        @Override
        public void run() {
            synchronized (PrintAToZ.words){
                while (PrintAToZ.index<PrintAToZ.words.length){
                    if(PrintAToZ.nextThread.equals(this.threadName)){
                        System.out.println(Thread.currentThread().getName()+"===="+PrintAToZ.words[PrintAToZ.index]);
                        PrintAToZ.index++;
                        if(PrintAToZ.index==PrintAToZ.words.length){ //防止角标越界
                            break;
                        }
                        if(isYuanying(PrintAToZ.words[PrintAToZ.index])){
                            PrintAToZ.nextThread = "yuanyin";
                        }else {
                            PrintAToZ.nextThread ="fuyin";
                            PrintAToZ.words.notify();//唤醒下一个操作线程
                        }
                    }else {
                        try{
                            //放弃对象锁,进入对象的等待锁池中,
                            // 直到其他线程调用本对象notity()方法后,本线程被唤醒.
                            PrintAToZ.words.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    protected static  class  FuThread implements Runnable{
        private String threadName="fuyin";
        @Override
        public void run() {
            synchronized (PrintAToZ.words){
                while (PrintAToZ.index<PrintAToZ.words.length){
                    if(PrintAToZ.nextThread.equals(this.threadName)){
                        System.out.println(Thread.currentThread().getName()+"===="+PrintAToZ.words[PrintAToZ.index]);
                        PrintAToZ.index++;
                        if(PrintAToZ.index==PrintAToZ.words.length){ //防止角标越界
                             break;
                        }

                        if(isYuanying(PrintAToZ.words[PrintAToZ.index])){
                            PrintAToZ.nextThread = "fuyin";
                        }else {
                            PrintAToZ.nextThread ="yuanyin";
                            PrintAToZ.words.notify();//唤醒下一个操作线程
                        }
                    }else {
                        try{
                            //放弃对象锁,进入对象的等待锁池中,
                            // 直到其他线程调用本对象notity()方法后,本线程被唤醒.
                            PrintAToZ.words.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}

