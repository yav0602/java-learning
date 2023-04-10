package com.yavdev.section11.StoreFront;

public class Phone extends ProductItem {
    public Phone(String name, double price, String description) {
        super(name, ProductType.PHONE, price, description);
    }

    @Override
    public void showDetails() {
        System.out.printf("A phone %s, %s. Price is %8.2f", name, description, price);
    }
}
