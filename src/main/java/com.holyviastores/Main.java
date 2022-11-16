package com.holyviastores;


import com.holyviastores.enums.Gender;
import com.holyviastores.model.Customer;
import com.holyviastores.model.Store;
import com.holyviastores.util.FileUtil;
import com.holyviastores.service.*;
import com.holyviastores.service.serviceImpl.*;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Store store = new Store();
        ProductService productService = new ProductServiceImpl(new FileUtil());
        productService.addingProductToStoreProducts(store)
                .thenRun(()->{
                    store.getProductList().forEach(System.out::println);
                })
                .join();

       CustomerService customerService = new CustomerServiceImpl();
       CashierService cashierService = new CashierServiceImpl();

        Customer customer1 = new Customer(2002, "John", "Martins",
                234009987677L, Gender.MALE, "jon@gmail.com", 50000.00, new ArrayList<>());
        Customer customer2 = new Customer(2003, "Mark", "Anthony",
                234009987677L, Gender.MALE, "jon@gmail.com", 10000.00, new ArrayList<>());
        Customer customer3 = new Customer(2004, "Adams", "Sandler",
                234009987677L, Gender.MALE, "jon@gmail.com", 20000.00, new ArrayList<>());
        Customer customer4 = new Customer(2005, "Michael", "Brown",
                234009987677L, Gender.MALE, "jon@gmail.com", 80000.00, new ArrayList<>());

//        Thread thread1 = new Thread(() -> customerService.buyProduct(customer1, store,"Salt", 15));
//        Thread thread2 = new Thread(() -> customerService.buyProduct(customer2, store, "Salt", 15));
//        Thread thread3 = new Thread(() -> customerService.buyProduct(customer3, store, "Salt", 15));
//        Thread thread4 = new Thread(() -> customerService.buyProduct(customer4, store, "Salt", 15));
//
//        thread1.start();
//        Thread.sleep(900);
//
//        thread2.start();
//        Thread.sleep(500);
//
//        thread3.start();
//        Thread.sleep(1000);
//
//        thread4.start();
//        Thread.sleep(1300);

        customerService.buyProduct(customer1, store,"Salt", 15);
        customerService.buyProduct(customer2, store, "Milo", 2);
        customerService.buyProduct(customer3, store, "Bread", 5);
        customerService.buyProduct(customer4, store, "Salt", 15);

        Thread t1 = new Thread(() -> cashierService.sellProduct(customer1));
        Thread t2 = new Thread(() -> cashierService.sellProduct(customer2));
        Thread t3 = new Thread(() -> cashierService.sellProduct(customer3));
        Thread t4 = new Thread(() -> cashierService.sellProduct(customer4));

        t1.start();
        Thread.sleep(400);
        t2.start();
        Thread.sleep(700);
        t3.start();
        Thread.sleep(900);
        t4.start();
        Thread.sleep(1200);
    }
}

