package com.longfei.easy;

/**
 * @author wlf
 * @time 2021/5/27
 */
public class SingleNumberHot136 {
    /**
     * 异或：
     * 1. 归零律：a ⊕ a = 0
     * 2. 恒等律：a ⊕ 0 = a
     * 3. 交换律：a ⊕ b = b ⊕ a
     * 4. 结合律：a ⊕b ⊕ c = a ⊕ (b ⊕ c) = (a ⊕ b) ⊕ c;
     * 5. 自反：a ⊕ b ⊕ a = b.
     * <p>
     * nums {1,2,3,4,1,2,3} ，1^2^3^4^1^2^3 = （1^1)^(2^2)^(3^3)^4= 0^0^0^4 = 4
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tmp = tmp ^ nums[i];
        }
        return tmp;
    }
}    