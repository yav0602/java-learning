package com.yavdev.section14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class PalindromeManipulator2 {
    private static final Random random = new Random();

    public static void main(String[] args) {
        String[] names = {"Anna", "Nikolay", "Bob", "Artur", "Kirill", "Alex"};
        List<String> namesList = new ArrayList<>(Arrays.asList(names));
        List<UnaryOperator<String>> stringFns = new ArrayList<>();

        stringFns.add(String::toUpperCase);
        stringFns.add(str -> str + " " +
                getRandomChar() +
                "." +
                " " +
                new StringBuilder(str).reverse());

        for (var stringFn : stringFns) {
            namesList.replaceAll(stringFn);
        }
        namesList.removeIf(PalindromeManipulator2::isLastNamePalindrome);

        String[] names2 = {"Artur", "Kirill", "Nikolay"};
        Consumer<String> s0 = s -> System.out.print(s.charAt(0));
        Consumer<String> s1 = s -> System.out.print(" - ");
        Consumer<String> s2 = System.out::println;

        Arrays.asList(names).forEach(s0
                .andThen(s1)
                .andThen(s2)
        );

    }

    private static char getRandomChar() {
        return (char) random.nextInt('A', 'Z');
    }

    private static boolean isLastNamePalindrome(String str) {
        String[] fullNameSplit = str.split(" ");
        String firstName = fullNameSplit[0];
        String lastName = fullNameSplit[2];

        return firstName.equals(lastName);
    }
}
