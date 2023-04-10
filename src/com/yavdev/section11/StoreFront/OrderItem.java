package com.yavdev.section11.StoreFront;

final class OrderItem {
    private final ProductItem product;
    private int quantity;

    public OrderItem(ProductItem product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public ProductItem getProduct() {
        return product;
    }
}
