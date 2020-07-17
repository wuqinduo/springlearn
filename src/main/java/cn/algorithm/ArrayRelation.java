package cn.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class ArrayRelation {
    public static void main(String[] args) {
    }

    //1.数组交集--Map实现方式（平时开发最常用的一种方式）
    public void inetersectMap(){
        //先把一个数组放入map
        //再遍历另一个数组，map.containKey
    }

    //2.数组交集--指针实现
    public int[] inetersectPointer(int[] nums1,int[] nums2){
        //先排序
        //两指针在两个数组里移动。
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();

        int p1 = 0,p2=0;
        while (p1<nums1.length && p2<nums2.length){
            //每一次遍历都有三种情况
            if(nums1[p1]<nums2[p2]){
                p1++;
            }else if(nums1[p1]>nums2[p2]){
                p2++;
            }else {
                result.add(nums1[1]);
                p1++;p2++;
            }
        }
        int[] res = new int[result.size()];
        for(int i = 0; i < res.length; i++) res[i] = result.get(i);
        return res;
    }

    //3.数组--股票买卖最佳时机 (简单级别)
    public void maxProfit(int[] prices){
        int profit=0;
        //精髓在于今天比昨天底时，跳过
        for (int i=0;i<prices.length;i++){
            int tmp = prices[i]-prices[i-1];
            if(tmp>0){
                profit+=tmp;
            }
        }
    }

    //4.数组--股票买卖的最佳时机-不带带冷冻期（中等） ---求最大利润。以利润为中心
    public void maxProfit1(int[] prices){


    }
}
