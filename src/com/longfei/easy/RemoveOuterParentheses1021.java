package com.longfei.easy;

/**
 * 删除最外层的括号
 *
 * @author islongfei
 * @date 2020.09.02
 */
public class RemoveOuterParentheses1021 {
    /**
     * solution 1. 双指针 (O(n)、O(n))：
     *          从左向右遍历，双指针记录左右最外括号下标（最后移除下标的括号）
     *          碰到左括号 count + 1, 碰到右括号 count - 1
     *          count = 0 ,则说明匹配到了最外层括号
     *
     * solution 2. 单指针 (O(n)、O(n)):
     *          同 solution 1 计数，将count != 1括号放入结果即可
     *
     * solution 3. 辅助栈 (O(n)、O(n)):
     *          碰到左括号入栈，碰到右括号消除栈顶
     *          入栈前为空，如果是左括号则是最外左括号
     *          如果栈为空，那么刚刚碰到的右括号则是最外右括号
     */
    public String removeOuterParentheses(String s) {
        StringBuffer res = new StringBuffer();
        int count = 0;
        char left = '(', right = ')'; //在循环外使用变量来定义括号，减少循环内char的创建，能有效优化性能
        for (char c : s.toCharArray()) {
            if (c == right) count--;
            if (count > 0) res.append(c);
            if (c == left) count++;
        }
        return res.toString();
    }
}


