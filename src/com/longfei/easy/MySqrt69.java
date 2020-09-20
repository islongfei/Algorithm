package com.longfei.easy;

/**
 * x 的平方根
 *
 * @author islongfei
 * @date 2020.09.20
 */
public class MySqrt69 {

    // s1. 二分: y = x^2 ，当x > 0,在 y 轴是单调递增的，并且有上下界
    // s2. 牛顿迭代法 todo
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        long left = 1, right = x, mid = 1;

        while (left <= right) {
            mid = left + (right - left) / 2;//防止越界，这里不去 (left + right) / 2
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) right;
    }


}
