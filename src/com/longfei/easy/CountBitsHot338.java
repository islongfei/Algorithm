package com.longfei.easy;

/**
 * @author wlf
 * @time 2021/6/2
 */
public class CountBitsHot338 {
    
    /**
     * Brian Kernighan 算法
     * <p>
     * https://blog.csdn.net/weixin_43688483/article/details/106349982
     * 对任何一个数 n，n & ( n − 1 )的结果是n的比特位最右端的1变为0的结果，根据此特性可以统计n有多少个二进制1
     * 计算从 0 到 n 的每个整数的「一比特数」的时间都不会超过 O(logn) ，总时间复杂度 O(nlogn)
     *
     * @param n
     * @return
     */
    public int[] countBits1(int n) {
        // 重复子问题
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }
    
    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }
    
    
    
}    