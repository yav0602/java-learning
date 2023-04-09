package com.yavdev.section10.Grocery;

import java.util.Scanner;

public class Cart {
    final static private int ADD_ITEM_OPTION = 1;
    final static private int REMOVE_ITEM_OPTION = 2;
    final static private int END_ADDING = 0;

    final private GroceryList groceryList;

    public Cart() {
        this.groceryList = new GroceryList();
    }

    public void displayCartOptions() {
        final Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");

        while(true) {
            boolean shouldExit = false;

            System.out.println("Available actions");
            System.out.println("0) End adding items");
            System.out.println("1) Add item(s) to list (comma delimited list)");
            System.out.println("2) Remove item(s) from list (comma delimited list)");
            System.out.print("Enter a number for which action you want to do: ");

            final int option = scanner.nextInt();

            switch (option) {
                case ADD_ITEM_OPTION -> {
                    final String[] items = readInputItems(scanner);
                    groceryList.addItems(items);
                }
                case REMOVE_ITEM_OPTION -> {
                    final String[] items = readInputItems(scanner);
                    groceryList.removeItems(items);
                }
                case END_ADDING -> shouldExit = true;
                default -> System.out.println("Undefined option! Please, try again");
            }

            if(shouldExit) {
                break;
            }
        }

        System.out.println("You grocery list:\n" + groceryList.getGroceryList());
        scanner.close();
    }

    private String[] readInputItems(Scanner scanner) {
        String itemsLine = scanner.next();
        return itemsLine.split(", ");
    }
}
