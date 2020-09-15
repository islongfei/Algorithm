package com.longfei.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 *
 * @author islongfei
 * @date 2020.09.09
 */
public class GenerateParenthesis22 {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate2(0, 0, n, "");
        return res;
    }

    private void generate2(int left, int right, int n, String s) {
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        // 剪枝
        // 1. 左括号不能大于n
        // 2. 左括号数 > 右括号才能去加右括号
        if (left < n) {
            generate2(left + 1, right, n, s + "(");
        }
        if (right < n && right < left) {
            generate2(left, right + 1, n, s + ")");
        }
    }


    private void generate(int level, int max, String s) {
        if (level >= max) {
            System.out.println(s);
            return;
        }

        //String s1 = s+"(";
        //String s2 = s+")";

        //1. 左括号不能大于3
        //2. 左括号数 > 右括号才能去加右括号

        generate(level + 1, max, s + "(");
        generate(level + 1, max, s + ")");
    }


    public static void main(String[] args) {
        GenerateParenthesis22 g = new GenerateParenthesis22();
        g.generateParenthesis(3);
    }
}
