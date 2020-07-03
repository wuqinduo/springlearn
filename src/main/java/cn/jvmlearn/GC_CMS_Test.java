package cn.jvmlearn;

/**
 *
 -verbose:gc //在控制台输出GC情况//-Xloggc: filepath  //将GC日志输出到指定文件中
 -Xms20M
 -Xmx20M 堆内存指定20M，不可扩容
 -Xmn10M  新生代10M
 -XX:+PrintGCDetails //在控制台输出详细的GC情况
 -XX:SurvivorRatio=8 新生代eden 和 survivor的空间比例8:1:1
 -XX:+UseConcMarkSweepGC 指定老年代的回收器CMS，cms只能用于老年代


 debug模式运行。

 清晰的观察到CMS 7步骤
 */
public class GC_CMS_Test {
    public static void main(String[] args) {
        int size = 1024*1024;
        byte[] myAlloc1 =  new byte[4* size];//第一次在新生代申请了4M内存

        System.out.println("11111");

        byte[] myAlloc2 =  new byte[4* size];

        System.out.println("22222");

        byte[] myAlloc3 =  new byte[2* size];

        System.out.println("33333");

        byte[] myAlloc4 =  new byte[4* size];

        System.out.println("44444");
    }
}
