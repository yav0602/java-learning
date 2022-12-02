package com.yavdev.section6;

public class TeenNumberChecker {
    final static private int minAge = 13;
    final static private int maxAge = 19;

    public static boolean hasTeen(int age1, int age2, int age3) {
        return isTeen(age1) || isTeen(age2) || isTeen(age3);
    }

    public static boolean isTeen(int number) {
        return number >= minAge && number <= maxAge;
    }
}
