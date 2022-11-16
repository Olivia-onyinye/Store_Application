package com.holyviastores.model;

import java.util.Comparator;

public class CustomerOrderComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer o2, Customer o1) {
        if(o1.getCart().get(0).getQuantity() > o2.getCart().get(0).getQuantity()){
            return -1;
        } else return o1.getCart().get(0).getQuantity() < o2.getCart().get(0).getQuantity() ? -1 : 0;
    }
    @Override
    public Comparator<Customer> thenComparing(Comparator<? super Customer> other) {
        return Comparator.super.thenComparing(other);
    }
}
