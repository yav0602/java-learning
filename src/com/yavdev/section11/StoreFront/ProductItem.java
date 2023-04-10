package com.yavdev.section11.StoreFront;

enum ProductType {
    CLOTHES,
    PHONE

}

abstract class ProductItem {
    protected final String name;
    protected final ProductType type;
    protected final double price;
    protected final String description;

    public ProductItem(String name, ProductType type, double price, String description) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public abstract void showDetails();

    public final double getPrice() {
        return price;
    }

    public final double getPrice(int quantity) {
        return this.price * quantity;
    }

    public final void printPricedLine(int quantity) {
        System.out.printf("%s %s, %2d x UAH%8.2f", type, name, quantity, price);
    }

}
