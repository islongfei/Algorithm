package com.longfei.medium;

/**
 * 盛水最多的容器
 */
public class MaxArea11 {
    //双指针法
    //向内移动一格板，拿到前后的最大面积
    //向内移动短板，面积有可能增大，向内移动长板，面积一定会减少
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;

        while (i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]) :
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
}

