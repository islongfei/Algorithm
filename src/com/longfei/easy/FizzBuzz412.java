package com.longfei.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Fizz Buzz
 *
 * @author islongfei
 * @date 2020.09.03
 */
public class FizzBuzz412 {
    public List<String> fizzBuzz(int n) {
        String Fizz = "Fizz", Buzz = "Buzz", FizzBuzz = "FizzBuzz";
        List<String> res = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                res.add(String.valueOf(i));
            } else if (i % 3 == 0 && i % 5 == 0) {
                res.add(FizzBuzz);
            } else if (i % 3 == 0) {
                res.add(Fizz);
            } else {
                res.add(Buzz);
            }
        }
        return res;
    }
}