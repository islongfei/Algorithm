package com.longfei.medium;

/**
 * 跳跃游戏
 *
 * @author islongfei
 * @date 2020.09.20
 */
public class CanJump55 {

    /**
     * s1. 贪心：由后往前遍历，用一个变量表示最后的位置，前面的元素能跳到这个变量的位置，则把这个元素位置记录
     * s2. 动规
     */
    public boolean canJump(int[] nums) {
        if (nums == null) return false;

        int end = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= end) end = i;
        }
        return end == 0;
    }
}
