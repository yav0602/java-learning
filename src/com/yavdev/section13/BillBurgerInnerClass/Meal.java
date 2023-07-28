package com.yavdev.section13.BillBurgerInnerClass;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    private String name;
    private DrinkSoda drinkSoda;
    private Burger burger;

    public Meal(String name) {
        this.name = name;
    }

    public double getOverallPrice() {
        double overallPrice = 0;
        if(drinkSoda != null) {
            overallPrice += drinkSoda.getPrice();
        }

        if(burger != null) {
            overallPrice += burger.getPrice();
        }

        return overallPrice;
    }

    public void addDrink(String name, double additionalPrice) {
        this.drinkSoda = new DrinkSoda(name, additionalPrice);
    }

    public void addBurger(String name, double additionalPrice) {
        this.burger = new Burger(name, additionalPrice);
    }

    public void addToppingToBurger(String name, double additionalPrice) {
        if (this.burger != null) {
            this.burger.addTopping(new Topping(name, additionalPrice));
        } else {
            System.out.println("ERROR: Burger is not added to meal");
        }
    }

    private class MealItem {
        enum MealItemType {
            Drink,
            Burger,
            Topping;

            private double getPriceByType() {
                return switch (this) {
                    case Drink -> 2.99;
                    case Burger -> 5.00;
                    case Topping -> 1.99;
                };
            }
        }

        private String name;
        private MealItemType type;
        private double price;

        MealItem(String name, MealItemType type) {
            this(name, type, 0);
        }

        MealItem(String name, MealItemType type, double additionalPrice) {
            this.price = type.getPriceByType() + additionalPrice;
            this.name = name;
            this.type = type;
        }

        protected double getPrice() {
            return this.price;
        }

        protected String getName() {
            return this.name;
        }

        @Override
        public String toString() {
            return """
                   Name: %16s
                   Type: %16s
                   Price: %11.2f UAH
                   """.formatted(this.name, this.type, this.price);
        }
    }

    private class DrinkSoda extends MealItem {

        DrinkSoda(String name) {
            super(name, MealItemType.Drink);
        }

        DrinkSoda(String name, double additionalPrice) {
            super(name, MealItemType.Drink, additionalPrice);
        }

        protected double getPrice() {
            return super.price;
        }
    }

    private class Burger extends MealItem {
        private List<Topping> toppings;

        Burger(String name) {
            super(name, MealItemType.Burger);
        }

        Burger(String name, double additionalPrice) {
            super(name, MealItemType.Burger, additionalPrice);
            toppings = new ArrayList<>();
        }

        private void addTopping(Topping topping) {
            this.toppings.add(topping);
        }

        @Override
        protected double getPrice() {
            final double burgerPrice = super.getPrice();
            double toppingsPriceSum = 0;

            for (var topping : this.toppings) {
                toppingsPriceSum += topping.getPrice();
            }

            return burgerPrice + toppingsPriceSum;
        }

        @Override
        public String toString() {
            final StringBuilder burgerInfo = new StringBuilder(super.toString());

            if (this.toppings.size() > 0) {
                burgerInfo.append("TOPPINGS:\n");

                for (int i = 0; i < this.toppings.size(); i++) {
                    final Topping currentTopping = this.toppings.get(i);
                    burgerInfo.append("%d) %s %5.2f UAH\n".formatted(
                                i + 1,
                                currentTopping.getName(),
                                currentTopping.getPrice()
                            )
                    );
                }
            }


            return burgerInfo.toString();
        }
    }

    private class Topping extends MealItem {

        Topping(String name) {
            super(name, MealItemType.Topping);
        }

        Topping(String name, double additionalPrice) {
            super(name, MealItemType.Topping, additionalPrice);
        }
    }

    @Override
    public String toString() {
        final StringBuilder mealInfo = new StringBuilder("%s\n".formatted(this.name.toUpperCase()))
                    .append("----------------------\n");

        if(drinkSoda != null) {
            mealInfo
                    .append("Drink soda info:\n")
                    .append("----------------------\n")
                    .append(drinkSoda)
                    .append("----------------------\n");
        }

        if(burger != null) {
            mealInfo
                    .append("Burger info:\n")
                    .append("----------------------\n")
                    .append(burger)
                    .append("----------------------\n");
        }

        mealInfo.append("OVERALL: %9.2f UAH".formatted(this.getOverallPrice()));

        return mealInfo.toString();
    }
}