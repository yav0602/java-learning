package com.yavdev.section14;

import java.util.ArrayList;
import java.util.List;

public class LambdaExercises {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        stringList.add("Kek cheburek");
        stringList.add("Yesterday I read a book about Willy Wonka's chocolate factory");

        stringList.add("1234567890");

        stringList.forEach((str) -> {
            String[] parts = str.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        });

        stringList.replaceAll((str) -> {
            StringBuilder returnVal = new StringBuilder();
            String[] chars = str.split("");
            for(int i = 0; i < chars.length; i++) {
                if(i % 2 == 1) {
                    returnVal.append(str.charAt(i));
                }
            }

            return returnVal.toString();
        });

        System.out.println(stringList);
    }
}
