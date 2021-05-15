package com.longfei.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wlf
 * @time 2021/5/15
 * 合并区间
 */
public class MergeHot56 {
    
    // [[1,3],[2,6],[8,10],[15,18]] -> [[1,6],[8,10],[15,18]]
    // [[2,3],[4,5],[1.0]] ->[[10]]
    public int[][] merge(int[][] intervals) {
        // sort
        // merge on new array, or merge on original array
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        int res[][] = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            // 当前区间的起始位置 > 结果数组中最后区间的终止位置,则不合并
            if (idx == -1 || interval[0] > res[idx][1]) {// 短路运算防止小标越界
                res[++idx] = interval;
            } else {
                // 反之则将该区间合并到结果的最后区间，存在包含时，则末尾取最大值
                res[idx][1] = Math.max(interval[1], res[idx][1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }
}