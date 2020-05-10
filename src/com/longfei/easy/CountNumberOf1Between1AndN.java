package com.longfei.easy;

/**
 * 求1-n中1出现的次数
 */
public class CountNumberOf1Between1AndN {

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(21));
    }

    public static int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = n; i > 0; i--) {
            /**
             *  对于每个数只需通过不断除10来除去已判断过的末尾数（切换数位），判断末尾数是否=1即可。
             *  比如216 先判断 216末尾的6，在判断21末尾的1，再判断2末尾的2.
             */
            for (int j = i; j > 0; j /= 10) {
                if (j % 10 == 1) count++;
            }
        }
        return count;
    }
}
