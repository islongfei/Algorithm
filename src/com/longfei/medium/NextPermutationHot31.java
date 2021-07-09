package com.longfei.medium;

/**
 * @author wlf
 * @time 2021/7/9
 * 下一个排列
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 */
public class NextPermutationHot31 {
    /**
     * 时间复杂度 O(n),最多两次扫描和一次反转
     * 空间复杂度O(1)
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            for (int j = nums.length - 1; j >= 0; j--) {
                if(nums[j]> nums[i]){
                    swap(i, j, nums);
                    break;
                }
            }
        }
        reverse(i+1, nums.length - 1, nums);
    }
    // 511
    public void reverse(int i, int j, int[] nums) {
        while (i < j) {
            swap(i++, j--, nums);
        }
    }
    
    // 123654 -> 124653 -> 124356
    // 132->231->213
    // 1 要找到下一个更大的，优先变动低位的数字，要由后往前遍历，看是不是递增的
    // 2 找到第一个不是递增的数，与后面第二大(末尾)的数交换
    // 3 交换后保证 交换区间内是递增的(反转区间内)
    // 4 没有交换过，说明由后往前一直递增，则反转
    
    public void swap(int a, int b, int nums[]) {
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
        
    }
}    