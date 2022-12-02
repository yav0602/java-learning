package com.yavdev.section4;

public class SpeedConverter {
    public final static double ONE_MILE_IN_KM = 1.609;

    public static long toMilesPerHour(double kilometersPerHour) {
        if(kilometersPerHour < 0) return -1;

        return Math.round(kilometersPerHour / ONE_MILE_IN_KM);
    }

    public static void printConversion(double kilometersPerHour) {
        if(kilometersPerHour < 0) {
            System.out.println("Invalid value");
        } else {
            System.out.println(
                    kilometersPerHour
                            + " km/h = "
                            + toMilesPerHour(kilometersPerHour)
                            + " mi/h"
            );
        }


    }
}
