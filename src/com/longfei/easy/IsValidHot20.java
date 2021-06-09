package com.longfei.easy;

import java.util.Stack;

/**
 * @author wlf
 * @time 2021/5/21
 * 有效的括号
 */
public class IsValidHot20 {
    // 解法1 打败的人较少,java自带的 stack集合太重，涉及到装箱拆箱加锁等等
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
    
    // StringBuffer自定义栈
    public boolean isValid2(String s) {
        StringBuffer ant = new StringBuffer();
        int n = s.length();
        char c, cc; // cc表示栈顶元素
        for (int i = 0; i < n; i++) {
            c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                ant.append(c);
            } else {
                if (ant.length() == 0) {
                    return false;
                }
                cc = ant.charAt(ant.length() - 1);
                if ((cc == '(' && c == ')') || (cc == '{' && c == '}') || (cc == '[' && c == ']')) {
                    ant.deleteCharAt(ant.length() - 1);
                    continue;
                } else {
                    return false;
                }
            }
        }
        if (ant.length() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
}