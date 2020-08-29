package com.longfei.easy;

/**
 * 移动零
 * <p>
 * solution 1. count zero then move
 * solution 2. new array
 * solution 3. index
 */
public class MoveZeroes283 {
    /**
     * 用一个变量 j 表示下一个非0元素要移动的地方
     * 把非0元素移动到前面，把0逐渐往后挪
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                //如果前面是0 则 i != j
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
