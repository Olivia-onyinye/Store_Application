package com.holyviastores.service.serviceImpl;

import com.holyviastores.exceptions.EmptyCartException;
import com.holyviastores.exceptions.EmptyQueueException;
import com.holyviastores.exceptions.InsufficientFundsException;
import com.holyviastores.model.Customer;
import com.holyviastores.model.Product;
import com.holyviastores.model.Store;
import com.holyviastores.service.CashierService;
import java.util.Queue;


public class CashierServiceImpl implements CashierService {
    public String sellProduct(Customer customer){
        synchronized (this){
            validateCustomerCart(customer);
            System.out.println("Attending to " + customer.getFirstName() + " on " + Thread.currentThread().getName());
            makePayment(customer);
            System.out.println(dispenseReceipt(customer));
            customer.getCart().clear();
            return "Thank you for shopping with us successfully";
        }
    }

    public String dispenseReceipt(Customer customer) {
        return "====================== PURCHASE RECEIPT ====================== \n" +
                "Name ===============" + customer.getFirstName() + "\n" +
                "---------------------------------------------------- \n" +
                "Total ============== " + getPriceOfItemsInCustomersCart(customer) + "\n" +
                "---------------------------------------------------- \n" +
                "Thanks for shopping with us";
    }
    @Override
    public String sellProductByQuantity(Store store) {
        if (store.getQueueList().isEmpty()) throw new EmptyQueueException("There are no customers on the queue");
        serveCustomerInQueue(store.getQueueList());
        return "Purchase successful, Thank you";
    }
    @Override
    public String sellByFirstInFirstOut(Store store) {
        if (store.getFifo().isEmpty()) throw new EmptyQueueException("There are no customers on the queue");
        else {
            serveCustomerInQueue(store.getFifo());
            return "Thank you for shopping with us successfully";
        }
    }
    private void serveCustomerInQueue(Queue<Customer> customerQueue){
            customerQueue.forEach(customer -> {
            validateCustomerCart(customer);
            System.out.println("Attending to " + customer.getFirstName() + " on " + Thread.currentThread().getName());
            makePayment(customer);
            System.out.println(dispenseReceipt(customer));
            customer.getCart().clear();
        });
    }
    private void validateCustomerCart(Customer customer) {
//        if (customer.getCart().isEmpty()) throw new EmptyCartException("You need to add items to your Cart");
//        if (getPriceOfItemsInCustomersCart(customer) > customer.getWalletBalance()) throw new InsufficientFundsException("Insufficient Balance");
    customer.getCart().stream().filter(cust -> customer.getCart().isEmpty())
            return

    }

    private double makePayment(Customer customer) {
        double walletBalance = customer.getWalletBalance();
        walletBalance -= getPriceOfItemsInCustomersCart(customer);
        customer.setWalletBalance(walletBalance);
        return walletBalance;
    }
    private double getPriceOfItemsInCustomersCart(Customer customer) {
        double total = 0;
        for (Product product : customer.getCart()) total += (product.getPrice() * product.getQuantity());
        return total;
    }
}