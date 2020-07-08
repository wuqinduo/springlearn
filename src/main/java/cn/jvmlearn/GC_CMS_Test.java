package cn.jvmlearn;

/**

 GC 学习第三节

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

        /*
        1.第一次在新生代申请了4M内存;新生代Eden8M,可以容下
         */
        byte[] myAlloc1 =  new byte[4* size];

        System.out.println("申请了4M");

        /*
         2.再申请4M，此时容不下了，触发新生代的GC

        [GC (Allocation Failure) [ParNew: 5736K->758K(9216K), 0.0060639 secs] 5736K->4856K(19456K), 0.0066836 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]

        【指定老年代CMS收集器，默认搭配新生代收集器ParNew】
         */
        byte[] myAlloc2 =  new byte[4* size];

        System.out.println("申请了4M");

        byte[] myAlloc3 =  new byte[2* size];

        /*
        3. 再申请 2M， 没事
         */
        System.out.println("申请了2M");

        /*
        4. 再申请4M ,发生两次GC

        FUllgc :7步骤，2STW

        【初始标记:STW】[GC (CMS Initial Mark) [1 CMS-initial-mark: 8363K(10240K)] 15069K(19456K), 0.0003923 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        [CMS-concurrent-mark-start]
        【并发标记】[CMS-concurrent-mark: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        [CMS-concurrent-preclean-start]
        申请了4M
        【并发预先清除】[CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        [CMS-concurrent-abortable-preclean-start]
        【并发可能失败的预先清除】[CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        【最终重新标记:STW】[GC (CMS Final Remark) [YG occupancy: 6869 K (9216 K)][Rescan (parallel) , 0.0003048 secs][weak refs processing, 0.0000252 secs][class unloading, 0.0001962 secs][scrub symbol table, 0.0002986 secs][scrub string table, 0.0000835 secs][1 CMS-remark: 8363K(10240K)] 15233K(19456K), 0.0009558 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        [CMS-concurrent-sweep-start]
        【并发清除】[CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        [CMS-concurrent-reset-start]
        【并发重置】[CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]


         */

        byte[] myAlloc4 =  new byte[4* size];

        System.out.println("申请了4M");
    }
}
