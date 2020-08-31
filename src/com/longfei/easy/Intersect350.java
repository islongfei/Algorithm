package com.longfei.easy;

import java.util.Arrays;

/**
 * 两个数组的交集 II
 *
 * @author islongfei
 * @date 2020.08.31
 */
public class Intersect350 {
    /**
     * solution 1. hash
     * solution 2. sort 双指针
     * solution 3. 内存很小，数据很大时：归并排序再双指针。
     *             工程应用: mysql join :https://www.infoq.cn/article/6XGx92FyQ45cMXpj2mgZ
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0, p2 = 0, p3 = 0, l1 = nums1.length, l2 = nums2.length;
        int res[] = new int[Math.min(l1, l2)];

        while (p1 < l1 && p2 < l2) {
            if (nums1[p1] < nums2[p2]) p1++;
            else if (nums1[p1] == nums2[p2]) {
                res[p3++] = nums1[p1];
                p1++;
                p2++;

            } else p2++;

        }
        return Arrays.copyOfRange(res, 0, p3);
    }
}
