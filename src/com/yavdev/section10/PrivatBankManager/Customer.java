package com.yavdev.section10.PrivatBankManager;

import java.util.ArrayList;
import java.util.Arrays;

class Customer {
    private static final int DEFAULT_BALANCE = 0;
    private final String name;
    private double balance;
    private final ArrayList<Double> transactions;

    public Customer(String name, int balance) {
        this.name = name;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Double amount) {
        if (amount >= 0 || Math.abs(amount) <= this.balance) {
            this.balance += amount;
            this.transactions.add(amount);
            System.out.println("Transaction was successful");
        } else {
            System.out.printf("Insufficient funds. Your balance is %.2f\n", this.balance);
        }
    }

    public String getName() {
        return name;
    }

    private String getFormattedTransactions() {
        final String[] formattedTransactions = new String[this.transactions.size()];
        for (int i = 0; i < this.transactions.size(); i++) {
            formattedTransactions[i] = String.format("%.2f UAH", this.transactions.get(i));
        }

        return Arrays.toString(formattedTransactions);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Customer customer) {
            return customer.name.equals(this.name);
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("""
                        Customer name -> %s
                        Balance -> %.2f UAH
                        Transactions -> %s
                        """,
                this.name,
                this.balance,
                this.getFormattedTransactions()
        );
    }
}
