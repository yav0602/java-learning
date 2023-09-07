package com.yavdev.section14;

import java.util.*;

public class PalindromeManipulator {

    private static final Random random = new Random();
    public static void main(String[] args) {
        String[] names = {"Anna", "Tanya", "Bob", "Artur", "Kirill", "Alex"};
        List<String> namesList = new ArrayList<>(Arrays.asList(names));

        namesList.replaceAll(s -> {
            String nameUppercase = s.toUpperCase();

            StringBuilder sBuilder = new StringBuilder(nameUppercase);
            sBuilder.append(" ")
                    .append(getRandomChar('A', 'Z'))
                    .append(".")
                    .append(" ")
                    .append(new StringBuilder(nameUppercase).reverse());

            return sBuilder.toString();
        });

        System.out.println("Initial names list: " + namesList);

        namesList.removeIf(s -> {
            String[] fullNameSplit = s.split(" ");
            String firstName = fullNameSplit[0];
            String lastName = fullNameSplit[2];

            return firstName.equals(lastName);
        });

        System.out.println("Formatted names list: " + namesList);
    }

    private static char getRandomChar(char startChar, char endChar) {
        return (char) random.nextInt(startChar, endChar);
    }
}
