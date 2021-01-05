package com.longfei.easy;

/**
 * 是否为回文数
 *
 * @author islongfei
 * @date 2021.01.05
 */
public class IsPalindrome9 {
    
    // 反转
    public boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        
        int y = 0;
        int temp = x;// 记录未处理的数
        int n = 0; // 记录每次个位数
        while (temp != 0) {
            n = temp % 10;
            y = y * 10 + n;
            temp = temp / 10;
        }
        return x == y;
    }
    
    // 双指针
    public boolean isPalindrome2(int x) {
        // -
        // !=
        // end ==
        char[] arr = Integer.toString(x).toCharArray();
        int j = arr.length - 1;
        if (arr.length == 0 || arr == null) {
            return false;
        }
        
        if (arr[0] == '-') {
            return false;
        }
        for (int i = 0; i < j; i++) {
            if (arr[i] != arr[j] && i <= j) {
                return false;
            }
            j--;
        }
        return true;
    }
}
