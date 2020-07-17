package cn.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class TwoSum {

    //两遍hash表
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();//值，下标
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        return null;
    }

    //一遍hash表(在迭代插入hashmap时， 回头看)
    public int[] twoSum1(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();//值，下标
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[] { i, map.get(complement) };
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
