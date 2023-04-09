package com.yavdev.section10.PrivatBankManager;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class BankManager {
    final private static Scanner  SCANNER = new Scanner(System.in);
    final private ArrayList<Customer>  customers = new ArrayList<>();

    public void start() {
        while (true) {
            System.out.println("------Bank manager-----");
            System.out.println("""
                    Choose action:
                    1) Add customer
                    2) Remove customer
                    3) Display customers
                    4) Add transaction
                    5) Exit
                    """);
            final int action = SCANNER.nextInt();

            switch (action) {
                case 1 -> this.addCustomer();
                case 2 -> this.removeCustomer();
                case 3 -> this.displayCustomers();
                case 4 -> this.addTransaction();
                case 5 -> {
                    return;
                }
                default -> System.out.println("Wrong action!!!");
            }
        }
    }

    private void addCustomer() {
        System.out.print("Customer name: ");
        final String name = SCANNER.next();
        System.out.print("Balance: ");
        final int balance = SCANNER.nextInt();
        final Customer newCustomer = new Customer(name, balance);

        if (!this.customers.contains(newCustomer)) {
            this.customers.add(newCustomer);
            System.out.println("New customer was add successfully!");
        } else {
            System.out.printf("The customer with name %s is already exists!", name);
        }

    }

    private void displayCustomers() {
        System.out.println(String.join("\n----------\n", this.getCustomerInfoArr()));
    }

    private void removeCustomer() {
        System.out.print("Write a name of customer, which you want to delete: ");
        final String name = SCANNER.next();
        final ListIterator<Customer> customerListIterator = this.customers.listIterator();

        while (customerListIterator.hasNext()) {
            if (customerListIterator.next().getName().equals(name)) {
                customerListIterator.remove();
                System.out.println("Customer was removed successfully!");
                return;
            }
        }

        System.out.println("Customer not found!");
    }

    private void addTransaction() {
        System.out.println("Select a customer where you want to add a transaction: ");
        final String name = SCANNER.next();
        System.out.println("Amount per transaction: ");
        final double amount = SCANNER.nextDouble();


        for (var customer : this.customers) {
            if(customer.getName().equals(name)) {
                customer.addTransaction(amount);
                return;
            }
        }
    }

    private String[] getCustomerInfoArr() {
        final var customersInfo = new String[this.customers.size()];

        for (int i = 0; i < this.customers.size(); i++) {
            customersInfo[i] = this.customers.get(i).toString();
        }

        return customersInfo;
    }
}
