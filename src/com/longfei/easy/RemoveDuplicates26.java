package com.longfei.easy;

/**
 * 删除数组中的重复项 num26
 */
public class RemoveDuplicates26 {
    public int removeDuplicates(int[] nums) {
        //快慢指针法
        //动画视频：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shi-ping-dong-hua-jie-xi-bao-ni-dong-by-novice2mas/
        if (nums == null || nums.length == 0) return 0;
        int i = 0, j = 1;//i记录不重复的元素
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j]; //和上一个数不相等直接赋值，前i个都是不重复的元素
            }
            j++;
        }
        return i + 1;
    }
}
