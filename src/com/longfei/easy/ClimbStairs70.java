package com.longfei.easy;

/**
 * 爬楼梯
 */
public class ClimbStairs70 {

    /**
     * 因为每次只能走 1-2 个台阶，那么走到第 n 个台阶时一定是 n-1 或者 n-2 个台阶上来的。
     * 第3阶的走法 = 第1阶的走法 + 第二阶的走法
     * 归纳为 f(n) = f(n-1) + f(n-2) 且不会有重复的走法
     */


    public int climbStairs(int n) {
        if (n <= 3) return n;

        //定义3个变量 去保存每走一步时，最近的3个走法数，不用定义数组，节省空间
        int r1 = 1, r2 = 2, r3 = 3;
        for (int i = 3; i <= n; i++) {
            r3 = r1 + r2;
            r1 = r2;
            r2 = r3;
        }
        return r3;
    }
}

