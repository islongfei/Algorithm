package com.longfei.easy;

/**
 * 删除数字中的重复项 num26
 */
public class RemoveDuplicates26 {
    public int removeDuplicates(int[] nums) {
        //快慢指针法
        //动画视频：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shi-ping-dong-hua-jie-xi-bao-ni-dong-by-novice2mas/
        if (nums == null || nums.length == 0) return 0;
        int i = 0, j = 1;

        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }
}
