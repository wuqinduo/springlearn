package cn.jvmlearn;

import java.util.ArrayList;
import java.util.List;
/*
GC 学习第二节

【1.oom后jump学习】
        List<OOM_JUMP_Test> list = new ArrayList();
        for (;;){
            list.add(new OOM_JUMP_Test());
        }
Dumping heap to java_pid9908.hprof ...

用jdk自带的工具jvisualm打开jump文件
> 可以清楚的看到异常错误的线程
> 类目录：可以看到的创建的类 信息
> 实例数：可以看到创建的实例数
> OQL控制台：类SQL语句，查询对象用的

【2. sout.gc】
当调用sout.gc时，会单独新开一个应用线程执行GC 。我们可以在jvisualm工具视图中看到各种变化



 */
public class OOM_JUMP_Test {
    public static void main(String[] args) {
        List<OOM_JUMP_Test> list = new ArrayList();
        for (;;){
            list.add(new OOM_JUMP_Test());
            //System.gc();
        }
    }
}
