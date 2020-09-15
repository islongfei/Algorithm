package com.longfei.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码字母组合
 *
 * @author islongfei
 * @date 2020.09.15
 */
public class LetterCombinations17 {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits.length() == 0) {
            return res;
        }

        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        search("", digits, 0, res, map);
        return res;

    }

    private void search(String s, String digits, int level, List<String> res, Map<Character, String> map) {
        if (level == digits.length()) {
            res.add(s);
            return;
        }

        String letter = map.get(digits.charAt(level));

        for (int j = 0; j < letter.length(); j++) {
            search(s + letter.charAt(j), digits, level + 1, res, map);
        }
    }
}
