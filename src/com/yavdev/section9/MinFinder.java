package com.yavdev.section9;

import java.util.Arrays;

public class MinFinder {
    static public int findMin(int... numbers) {
        int[] arrCopy = Arrays.copyOfRange(numbers, 1, numbers.length);
        int minValue = numbers[0];

        for (int number : numbers) {
            if(minValue > number) {
                minValue = number;
            }
        }

        return minValue;
    }
}
