package cn.jvmlearn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2020/7/3.
 */
public class OOM_Test {
    public static void main(String[] args) {
        List<OOM_Test> list = new ArrayList();
        for (;;){
            list.add(new OOM_Test());
            System.gc();
        }
    }
}
