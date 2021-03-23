package com.longfei.medium;

/**
 * 最长回文子串
 *
 * @author islongfei
 * @date 2021.03.12
 */
public class LongestPalindrome5 {
    
    
    //暴力
    public String longestPalindrome1(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        int begin = 0, maxlength = 1;
        char[] charArray = s.toCharArray(); //用str.charAt(i)每次会判断越界，增加时间复杂度
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (j - i + 1 > maxlength && validPalindrome(charArray, i, j)) {
                    maxlength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxlength);
    }
    
    private boolean validPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        LongestPalindrome5 l = new LongestPalindrome5();
        System.out.println(l.longestPalindrome1("abb"));
        
    }
    
}
