package com.longfei.medium;

/**
 * 计算 x 的 n 次幂
 *
 * @author islongfei
 * @date 2020.09.15
 */
public class MyPow50 {
    /**
     * s1. 暴力 O(n)：循环 n 次累乘
     * s2. 分治 O(logn)：例如 2^10 = 2^5*2^5，考虑 n 的奇偶情况
     */
    public double myPow(double x, int n) {
        return n >= 0 ? pow(x, n) : 1 / pow(x, -n);
    }

    private double pow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = pow(x, n / 2);
        return (n & 1) == 1 ? y * y * x : y * y;
    }
}
