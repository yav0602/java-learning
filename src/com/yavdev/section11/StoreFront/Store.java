package com.yavdev.section11.StoreFront;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {
    private static final Scanner SCANNER = new Scanner(System.in);

    private final List<ProductItem> productsForSaleList = new ArrayList<>();
    private final List<OrderItem> orderedProducts = new ArrayList<>();

    private void displayProducts(ProductType type) {
        for (int i = 0; i < this.productsForSaleList.size(); i++) {
            var product = this.productsForSaleList.get(i);
            if (product.type == type) {
                System.out.print((i + 1) + ") ");
                product.showDetails();
                System.out.println();
            }
        }
    }

    private void displayProducts() {
        for (int i = 0; i < this.productsForSaleList.size(); i++) {
            var product = this.productsForSaleList.get(i);
            System.out.print((i + 1) + ") ");
            product.showDetails();
            System.out.println();
        }
    }

    private void addOrder() {
        System.out.println("Type of product: ");
        String productTypeString = SCANNER.next();
        System.out.println("Select product, which you want");

        try {
            ProductType type = ProductType.valueOf(productTypeString);
            this.displayProducts(type);
        } catch (IllegalArgumentException e) {
            this.displayProducts();
        }

        System.out.println("Choose index of product");
        int productIndex = SCANNER.nextInt() - 1;
        System.out.println("Choose a quantity");
        int quantity = SCANNER.nextInt();

        var product = this.productsForSaleList.get(productIndex);

        for (var order : this.orderedProducts) {
            if (order.getProduct().name.equals(product.name)) {
                order.setQuantity(order.getQuantity() + Math.abs(quantity));
                return;
            }
        }

        this.orderedProducts.add(new OrderItem(product, quantity));
    }

    private void removeOrder() {
        System.out.println("Choose a product index from your order list:");
        for (int i = 0; i < this.orderedProducts.size(); i++) {
            var order = this.orderedProducts.get(i);
            var product = order.getProduct();
            var quantity = order.getQuantity();
            System.out.print((i + 1) + ") ");
            product.printPricedLine(quantity);
            System.out.println();
        }

        int orderIndex = SCANNER.nextInt() - 1;
        var selectedOrder = this.orderedProducts.get(orderIndex);

        System.out.println("Quantity to remove");
        int userQuantity = SCANNER.nextInt();
        int selectedOrderQuantity = selectedOrder.getQuantity();

        if (userQuantity >= selectedOrderQuantity) {
            this.orderedProducts.remove(orderIndex);
        } else {
            selectedOrder.setQuantity(selectedOrderQuantity - userQuantity);
        }
    }

    private void displayMyOrder() {
        double overallPrice = 0.0;
        for (var order : this.orderedProducts) {
            var product = order.getProduct();
            var quantity = order.getQuantity();
            product.printPricedLine(quantity);
            System.out.println();

            overallPrice += product.getPrice(quantity);
        }
        System.out.printf("Overall price = %8.2f UAH\n", overallPrice);
    }

    private void addProduct(ProductItem product) {
        this.productsForSaleList.add(product);
    }

    public static void main(String[] args) {
        Store store = new Store();

        var samsungPhone = new Phone("Samsung s22", 30000, "The best expensive android phone");
        var xiaomiPhone = new Phone("Xiaomi", 1000.50, "The best cheap android phone");
        var iphonePhone = new Phone("iPhone", 100000.99, "The piece of apple");

        var adidasSneakers = new Clothes("Adidas Sneakers", 3500, "The best sneakers for your boyfriend");
        var staffHoodie = new Clothes("Staff hoodie", 879.69, "Hoodie made of cotton 100%");

        store.addProduct(samsungPhone);
        store.addProduct(xiaomiPhone);
        store.addProduct(iphonePhone);
        store.addProduct(adidasSneakers);
        store.addProduct(staffHoodie);

        while (true) {
            System.out.println("-----Store Front-----");
            System.out.println("""
                    1) Display products
                    2) Order product
                    3) Remove order
                    4) Display my order
                    5) Exit
                    """);
            int action = SCANNER.nextInt();

            switch (action) {
                case 1 -> store.displayProducts();
                case 2 -> store.addOrder();
                case 3 -> store.removeOrder();
                case 4 -> store.displayMyOrder();
                case 5 -> {
                    return;
                }
                default -> System.out.println("Action not found");
            }

        }
    }
}

