package cn.jvmlearn;

/**
 * GC 学习第一节

 -verbose:gc
 -Xms20M  堆大小初始值
 -Xmx20M  堆最大值
 -Xmn10M  新生代值
 -XX:+PrintGCDetails 打印GC日志
 -XX:SurvivorRatio=8 新生比例


 【1.GC日志的解读】：格式组成：信息(附加信息)
 [GC (Allocation Failure) [PSYoungGen: 7783K->840K(9216K)] 7783K->6992K(19456K), 0.0036911 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]

 【1.1GC信息】
 GC (Allocation Failure) : GC 发生（原因）
 PS: Parallel Scavenge收集器
 7783K->840K(9216K) 垃圾回收之前新生代占空间 --->回收后新生代对象占空间(新生代总空间9m=8+1,；浪费10M)
 7783K->6992K(19456K) 总堆存活占用空间--->回收后总堆占用(总堆空间)
 0.0036911 secs 执行此次GC所耗费的时间

 《新生代释放大小- 总堆释放大小=从新生代进入老年代的容量大小》

 【1.2时间信息】
 user=0.00 执行此GC用户空间时间
 sys=0.00 执行此GC 内核空间耗费了多少时间
 real=0.00 真正执行的时间

 【2.内存解读】
 Heap
 PSYoungGen      total 9216K【新生代9M】, used 2288K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
     eden space 8192K, 27% used [0x00000000ff600000,0x00000000ff83c3e8,0x00000000ffe00000)
     from space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
     to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
 ParOldGen       total 10240K【老年代10M】, used 6880K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
    object space 10240K, 67% used [0x00000000fec00000,0x00000000ff2b8030,0x00000000ff600000)
 Metaspace 【元空间】      used 2846K, capacity 4486K, committed 4864K, reserved 1056768K
    class space    used 299K, capacity 386K, committed 512K, reserved 1048576K

【3.GC时机】
 Minor GC:
 FUllGC: 实际中一定要得避免

 【大对象进入老年代】

 */
public class GC_Test1 {
    public static void main(String[] args) {

        int size = 1024*1024;

        byte[] myAlloc1 =  new byte[2* size];
        System.out.println("1111");
        byte[] myAlloc2 =  new byte[2* size];
        System.out.println("2222");
        byte[] myAlloc3 =  new byte[3* size];
        System.out.println("3333");
        byte[] myAlloc4 =  new byte[4* size];
        System.out.println("4444");

    }
}
