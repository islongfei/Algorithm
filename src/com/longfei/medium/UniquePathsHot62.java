package com.longfei.medium;

/**
 * @author islongfei
 * @date 2021.04.17
 */
public class UniquePathsHot62 {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];

        //自底向上
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 每一步的走法 = 左一位的走法 + 上一位的走法
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m-1][n-1];
    }
}