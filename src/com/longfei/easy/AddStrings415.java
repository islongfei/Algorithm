package com.longfei.easy;

/**
 * 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * @author wlf
 * @time 2021/7/15
 */
public class AddStrings415 {
    /**
     * 时间复制度：O(max(num1.length, num2.length)), 空间复制度O(n)
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        while (i >= 0 || j >= 0 || add != 0) {
            int n = i < 0 ? 0 : num1.charAt(i) - '0'; //string.charAt(i)将返回一个字符(ASCII码值)，string.charAt(i)- '0'将返回实际的整数值
            int m = j < 0 ? 0 : num2.charAt(j) - '0';
            int r = n + m + add;
            res.append(r % 10);
            add = r / 10;
            i--;
            j--;
        }
        res.reverse();
        return res.toString();
    }
    
    public static void main(String[] args) {
        AddStrings415 a = new AddStrings415();
        System.out.println(a.addStrings("1123", "4357"));
    }
}    