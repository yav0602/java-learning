package com.yavdev;

import com.yavdev.section9.MinFinder;
import com.yavdev.section9.Reverser;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main( String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the length of array:");
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        System.out.println("Enter the numbers to fill array");
        for (int i = 0; i < arrayLength; i++) {
            int number = scanner.nextInt();
            array[i] = number;
        }

        System.out.println("Your array is " + Arrays.toString(array));
        System.out.println("Reversed array is " + Arrays.toString(Reverser.reverseArray(array)));;
        System.out.println("Min element in array is " + MinFinder.findMin(array));

        scanner.close();
    }
}
