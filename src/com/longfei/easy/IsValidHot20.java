package com.longfei.easy;

import java.util.Stack;

/**
 * @author wlf
 * @time 2021/5/21
 */
public class IsValidHot20 {
    // 解法1 打败的人较少
    public boolean isValid1(String s) {
        // 核心就是利用了栈先进后出的特点，栈顶元素就是最近的左括号，遇到右括号就在栈顶判断就行了
        Stack<Character> left = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            // 入栈
            if (c.equals('(') || c.equals('[') || c.equals('{')) {
                left.push(c);
            }
            // 出栈
            else if (!left.isEmpty() && left.peek().equals(getLeft(c))) {
                left.pop();
            } else {
                return false;
            }
        }
        return left.isEmpty();
    }
    
    private Character getLeft(Character c) {
        if (c.equals(')')) {
            return '(';
        } else if (c.equals(']')) {
            return '[';
        }
        return '{';
    }
}    