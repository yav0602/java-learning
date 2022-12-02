package com.yavdev.section4;

public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2) {
        final int numMultiplied1 = (int) (num1 * 1000);
        final int numMultiplied2 = (int) (num2 * 1000);

        return numMultiplied1 == numMultiplied2;
    }
}
