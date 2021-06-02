package com.longfei.easy;

import java.util.Random;

/**
 * @author wlf
 * @time 2021/6/2
 * 多数元素
 * 1、hashmap
 * 2、sort
 * 3、摩尔投票法（对拼）
 * 4、随机
 * 5、分治
 */
public class MajorityElementHot169 {
    
    /**
     * 摩尔投票法（对拼）
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int temp = nums[0];
        int count = 1; // 每个人初始票数为 1
        for (int i = 1; i < nums.length; i++) {
            if (temp == nums[i]) {
                count++;
            } else if (--count == 0) { //对拼 数量-1
                temp = nums[i];
                count = 1;
            }
        }
        return temp;
    }
    
    /**
     * 随机法 时间复制度O(n),随机常数次
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        for (; ; ) {
            int count = 0;
            int candidate = nums[new Random().nextInt(nums.length)];
            for (int num : nums) {
                if (num == candidate) {
                    count++;
                }
            }
            if (count > nums.length / 2) {
                return candidate;
            }
        }
    }
    
}