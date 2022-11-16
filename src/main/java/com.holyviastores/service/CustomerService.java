package com.holyviastores.service;

import com.holyviastores.model.Customer;
import com.holyviastores.model.Store;


public interface CustomerService {
    String buyProduct(Customer customer, Store store, String name, int quantity);
}
