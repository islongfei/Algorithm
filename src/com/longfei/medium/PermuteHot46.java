package com.longfei.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wlf
 * @time 2021/6/1
 * 全排列（回溯）
 */
public class PermuteHot46 {
    
    List<List<Integer>> res = new LinkedList<>();
    // https://mp.weixin.qq.com/s/nMUHqvwzG2LmWA9jMIHwQQ
    public List<List<Integer>> permute1(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums, track);
        System.out.println(res);
        return res;
        
    }
    
    private void backTrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 排除
            if (track.contains(nums[i])) { //链表使用contains方法需要 O(N) 的时间复杂度, 可以继续优化
                continue;
            }
            // 选择
            track.add(nums[i]);
            // 进入下一层决策树
            backTrack(nums, track);
            // 撤销（删除末尾元素，向上回溯）
            track.removeLast();
            
        }
    }
}    