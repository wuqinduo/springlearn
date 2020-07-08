package cn.collectionLearn;

import java.util.HashMap;

/**
 * Created by dell on 2020/7/8.
 */
public class HashMapLearn {
    public static void main(String[] args) {
        String k1 = "wuqinduo";
        String k2 = "zhangsan";

        System.out.println(k1.hashCode());
        System.out.println(k2.hashCode());

        System.out.println(HashMapLearn.toBinaryString(k1.hashCode()));
        System.out.println(HashMapLearn.toBinaryString(k2.hashCode()));

        System.out.println(k1.hashCode()>>>16);
        System.out.println(k2.hashCode()>>>16);
        System.out.println(HashMapLearn.toBinaryString(k1.hashCode()>>>16));
        System.out.println(HashMapLearn.toBinaryString(k2.hashCode()>>>16));

        System.out.println(hash(k1));
        System.out.println(hash(k2));
    }
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    // 替代Integer.toBinaryString()
    public static String toBinaryString(int num) {
        if (num == 0) return ""+0;
        String result = "";
        // 左面0的个数
        int n = Integer.numberOfLeadingZeros(num);
        num <<= n;
        for (int i=0; i<32-n; ++i) {
            int x = (Integer.numberOfLeadingZeros(num) == 0)?1:0;
            result += x;
            num <<= 1;
        }
        return result;
    }
}
