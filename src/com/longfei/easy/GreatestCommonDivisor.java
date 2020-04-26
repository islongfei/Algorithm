package com.longfei.easy;

/**
 * 求两个数的最大公约数
 */
public class GreatestCommonDivisor {

    /**
     * 欧几里得算法（辗转相除法）
     * 两个正整数，它们的最大公约数 = 大数除以小数的余数和小数之间的最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisorV1(int a, int b) {
        int big = a > b ? a : b;
        int small = a > b ? b : a;
        if (big % small == 0) {
            return small;
        }
        return getGreatestCommonDivisorV1(big % small, small);

    }

    /**
     * getGreatestCommonDivisorV3()方法在下面简写为g()
     * 当a偶 b偶时，g(a,b) = 2*g(a/2,b/2) = 2*g(a>>1,b>>1);
     * 当a偶 b奇时，g(a,b) = 2*g(a/2,b) = g(a>>1,b);
     * 当a奇 b偶时，g(a,b) = 2*g(a,b/2) = g(a,b>>1);
     * 当a奇 b奇时，g(a,b) = g(a-b,b),此时a-b为偶数 b为奇数,又可利用上面的运算;
     *
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisorV3(int a, int b) {
        if (a == b) {
            return a;
        }

        if ((a & 1) == 0 && (b & 1) == 0) {
            return getGreatestCommonDivisorV3(a >> 1, b >> 1) << 1;
        } else if ((a & 1) == 0 && (b & 1) == 1) {
            return getGreatestCommonDivisorV3(a >> 1, b);
        } else if ((a & 1) == 1 && (b & 1) == 0) {
            return getGreatestCommonDivisorV3(a, b >> 1);
        } else {
            int big = a > b ? a : b;
            int small = a > b ? b : a;
            return getGreatestCommonDivisorV3(big - small, small);
        }


    }

    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisorV3(865, 35));
    }
}
