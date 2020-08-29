package com.longfei.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律
 */
public class WordPattern290 {
    public static boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        HashSet<String> valueSet = new HashSet<>();// 空间换时间
        String[] strArray = str.split(" ");
        if (pattern.length() != strArray.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);
            if (map.containsKey(key)) {
                if (!map.get(key).equals(strArray[i])) return false;
            } else {
                //HashSet contains()为 O(1),而 HashMap containsValue 为 O(n)-O(n^2) https://www.cnblogs.com/jiezai/p/11149932.html
                if (valueSet.contains(strArray[i])) return false;
                else {
                    map.put(key, strArray[i]);
                    valueSet.add(strArray[i]);
                }
            }
        }
        return true;
    }
}
