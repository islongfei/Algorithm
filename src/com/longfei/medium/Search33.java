package com.longfei.medium;

/**
 * 搜索旋转排序数组
 *
 * @author islongfei
 * @date 2020.09.21
 */
public class Search33 {

    // s1. 暴力：还原升序数组 -> 二分
    // s2. 二分查找：首先判断哪一部分是有序的
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            //0 -> mid 有序情况下，向后约束
            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) { //target < nums[0]) 考虑发生旋转的情况
                left = mid + 1;
                // 0 -> mid 发生旋转时，向后约束
            } else if (target > nums[mid] && target < nums[0]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left == right && nums[left] == target ? left : -1;
    }
}
