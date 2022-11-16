package com.holyviastores.service;

import com.holyviastores.model.Customer;
import com.holyviastores.model.Product;
import com.holyviastores.model.Store;
import lombok.NonNull;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public interface CashierService {

    String  dispenseReceipt(Customer customer);

    String sellProductByQuantity (Store store);

    String sellByFirstInFirstOut(Store store);
     String sellProduct(Customer customer);
}
