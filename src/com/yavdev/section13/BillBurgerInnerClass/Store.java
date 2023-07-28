package com.yavdev.section13.BillBurgerInnerClass;

public class Store {
    public static void main(String[] args) {
        Meal firstMeal = new Meal("McDonald's meal");
        firstMeal.addDrink("Coca cola", 0);
        firstMeal.addBurger("Big Mac", 0);
        firstMeal.addToppingToBurger("Fried meat", 30.50);
        firstMeal.addToppingToBurger("Cheese", 9.99);

        System.out.println(firstMeal);
    }
}
