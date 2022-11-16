package com.holyviastores.model;

import com.holyviastores.enums.Gender;
import java.util.ArrayList;
import java.util.Objects;

public class Customer extends Person {
    private double walletBalance;
    private ArrayList<Product> cart;

    @Override
    public String toString() {
        return "Customer{" +
                "walletBalance=" + walletBalance +
                ", cart=" + cart +
                '}';
    }

    public Customer(Integer id, String firstName, String lastName, Long phoneNo, Gender gender,
                    String email, double walletBalance, ArrayList<Product> cart) {
        super(id, firstName, lastName, phoneNo, gender, email);
        this.walletBalance = walletBalance;
        this.cart = cart;
    }

    public Customer() {
        super();
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return Double.compare(customer.walletBalance, walletBalance) == 0 && cart.equals(customer.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(walletBalance, cart);
    }
}

