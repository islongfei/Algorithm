package com.longfei.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数相加
 */
public class TwoSum1 {
    /**
     * map key为数组元素，value为下标
     * 因为数组中没有重复元素，每次比较 target 与元素相减是否等于数组另一个元素即可
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
