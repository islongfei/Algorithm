package com.longfei.easy;

/**
 * @author wlf
 * @time 2021/6/8
 * 汉明距离(两个数字对应二进制位不同的位置的数目)
 */
public class HammingDistanceHot416 {
    /**
     * Brian Kernighan 算法
     * <p>
     * https://blog.csdn.net/weixin_43688483/article/details/106349982
     * 对任何一个数 n，n & ( n − 1 )的结果是n的比特位最右端的1变为0的结果，根据此特性可以统计n有多少个二进制1
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance1(int x, int y) {
        int temp = x ^ y;
        int res = 0;
        while (temp > 0) {
            temp &= temp - 1;
            res++;
        }
        return res;
    }
    
}