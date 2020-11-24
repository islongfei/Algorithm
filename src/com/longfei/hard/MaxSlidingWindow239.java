package com.longfei.hard;

/**
 * 滑动窗口最大值
 *
 * @author islongfei
 * @date 2020.08.30
 */
public class MaxSlidingWindow239 {

    /**
     * solution 1. 暴力 O(n*k)
     * solution 2. O(n) 单调队列
     * solution 3. 双端队列
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i,// 窗口起始元素
        j,//当前元素
        length = nums.length;
        if (length == 0 || length < k) return new int[0];
        int res[] = new int[length - k + 1];
        int lastMaxIndex = -1;
        for (i = 0; i <= length - k; i++) {
            j = i + k - 1;
            // 当前元素 > 上个窗口最大值，则该元素为此窗口最大值
            if (lastMaxIndex != -1 && nums[j] >= nums[lastMaxIndex]) {
                lastMaxIndex = j;
                res[i] = nums[lastMaxIndex];
            }
            // 当前元素 < 上个窗口最大值，且上个窗口最大值也在当前窗口
            else if (i <= lastMaxIndex) {
                res[i] = nums[lastMaxIndex];
            }
            //当前元素 < 上个窗口最大值，但是上个窗口最大值没在当前窗口，此时就得找出k中最大的
            else {
                int max = Integer.MIN_VALUE;
                int maxIndex = 0;
                for (int z = i; z <= j; z++) {
                    if (nums[z] > max) {
                        max = nums[z];
                        maxIndex = z;
                    }
                    lastMaxIndex = maxIndex;
                    res[i] = max;
                }
            }
        }
        return res;
    }
}
