package com.yavdev.section11.StoreFront;

public class Clothes extends ProductItem {

    public Clothes(String name, double price, String description) {
        super(name, ProductType.CLOTHES, price, description);
    }

    @Override
    public void showDetails() {
        System.out.printf("%s underwear, %s. Price is %8.2f", name, description, price);
    }
}
