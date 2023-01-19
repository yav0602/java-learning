package com.yavdev.section9;

public class Reverser {
    static public int[] reverseArray(int... arr) {
        int[] reversedArr = new int[arr.length];

        for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
            reversedArr[i] = arr[j];
        }

        return reversedArr;
    }
}
