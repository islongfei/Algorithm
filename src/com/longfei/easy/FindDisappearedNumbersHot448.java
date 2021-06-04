package com.longfei.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wlf
 * @time 2021/6/4
 * 找到所有数组中消失的数字
 */
public class FindDisappearedNumbersHot448 {
    
    /**
     * 找到下标=该数的数target, 将target改为负数。修改完成之后，下标对应的元素还是正数，那么此下标就是消失的数
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int target;
        for (int i = 0; i < nums.length; i++) {
            target = Math.abs(nums[i]) - 1;
            if (nums[target] > 0) {
                nums[target] = -nums[target];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}    