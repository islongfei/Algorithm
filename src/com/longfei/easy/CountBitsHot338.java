package com.longfei.easy;

/**
 * @author wlf
 * @time 2021/6/2
 * 比特位计数
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
    
    /**
     * 重复子问题 dp
     * 最高有效位：如果正整数 n 是 2 的整数次幂,则 n 的二进制表示中只有最高位是 1,其余都是 0,此时 y&(y -1) = 0
     *
     * @param n
     * @return
     */
    public int[] countBits2(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i < n + 1; i++) {
            if ((i & (i - 1)) == 0) {
                bits[i] = 1;
                highBit = i;
            } else {
                bits[i] = bits[i - highBit] + 1; // +1 是highBit自带的 1
            }
        }
        return bits;
    }
    
}