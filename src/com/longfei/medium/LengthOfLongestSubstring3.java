package com.longfei.medium;

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
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));
    }
    
    // 用set做，舍弃
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s == null) {
            return 0;
        }
        char[] str = s.toCharArray();
        char lastIndex = 0;
        Set set = new HashSet();
        int length = 0, lastSize;
        for (int i = 0; i < str.length; i++) {
            lastSize = set.size();
            if (lastSize == 0 && lastIndex != 0 && lastIndex != str[i]) {
                set.add(lastSize);
            }
            set.add(str[i]);
            length = length > set.size() ? length : set.size();
            if (lastSize == set.size()) {
                // add 之后重复。size没变, aab情况要去记录上一个元素
                lastIndex = str[i];
                set.clear();
            }
        }
        return length;
    }
}
