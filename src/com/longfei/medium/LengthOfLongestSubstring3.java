package com.longfei.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 无重复的字符串的最长子串
 *
 * @author islongfei
 * @date 2021.01.05
 */
public class LengthOfLongestSubstring3 {
    
    public static void main(String[] args) {
        LengthOfLongestSubstring3 l = new LengthOfLongestSubstring3();
        System.out.println(l.lengthOfLongestSubstring("dvdf"));
    }
    
    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0; //窗口最左边界
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1); //遇到重复的则向左滑一位
            }
            map.put(c, i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
    
}
