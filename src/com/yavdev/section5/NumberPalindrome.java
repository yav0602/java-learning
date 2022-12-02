package com.yavdev.section5;

public class NumberPalindrome {
    public static boolean isPalindrome(int number) {
        int absNumber = Math.abs(number);
        int result = 0;

        for (int i = absNumber; i != 0; i /= 10) {
            int mod = i % 10;
            result *= 10;
            result += mod;
        }

        return absNumber == result;
    }
}
