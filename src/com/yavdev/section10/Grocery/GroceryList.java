package com.yavdev.section10.Grocery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class GroceryList {
    final private ArrayList<String> groceryList;

    protected GroceryList() {
        this.groceryList = new ArrayList<>();
    }

    protected ArrayList<String> getGroceryList() {
        return groceryList;
    }

    protected void addItems(String[] items) {
        int counter = 0;

        for (String item : items) {
            if(!includes(item)) {
                groceryList.add(item);
                counter++;
            }
        }

        if(counter > 0) {
            sortGroceryList();
            System.out.printf("%d items added", counter);
        } else {
            System.out.println("There aren't any groceries, that added to the list");
        }


    }

    protected void removeItems(String[] items) {
        int previousLength = groceryList.size();

        groceryList.removeAll(List.of(items));

        int currentLength = groceryList.size();
        int numOfRemoved = previousLength - currentLength;

        System.out.printf("%d items removed", numOfRemoved);
    }

    private void sortGroceryList() {
        this.groceryList.sort(Comparator.naturalOrder());
    }

    private boolean includes(String item) {
        return this.groceryList.contains(item);
    }
}
