package com.longfei.easy;

/**
 * 买卖股票的最佳时机
 *
 * @author islongfei
 * @date 2020.09.20
 */
public class MaxProfit121 {

    /**
     * s1. 贪心：只要后一天比前面大，那么就前一天买后一天抛
     * s2. 动规: todo
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                max += prices[i] - prices[i - 1];
        }
        return max;
    }
}
