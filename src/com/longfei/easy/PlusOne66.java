package com.longfei.easy;

/**
 * 数组加1
 */
public class PlusOne66 {
    /**
     * 个位非9，+1直接返回
     * 个位为9，+1后是否为0,再向上一位+1，依次类推
     * 如果出现全是9的情况，那么for循环是不会返回的，则数组长度+1，第一位为1其余为0
     */
    public int[] plusOne(int[] digits) {
        int l = digits.length;
        for (int i = l - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }

        digits = new int[l + 1];
        digits[0] = 1;
        return digits;
    }
}
