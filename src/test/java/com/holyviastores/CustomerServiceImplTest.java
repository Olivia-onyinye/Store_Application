package com.holyviastores;

import com.holyviastores.enums.Gender;
import com.holyviastores.exceptions.ItemNotInStoreException;
import com.holyviastores.exceptions.ProductException;
import com.holyviastores.util.FileUtil;
import com.holyviastores.model.Customer;
import com.holyviastores.model.Product;
import com.holyviastores.model.Store;
import com.holyviastores.service.CustomerService;
import com.holyviastores.service.ProductService;
import com.holyviastores.service.serviceImpl.CustomerServiceImpl;
import com.holyviastores.service.serviceImpl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


class CustomerServiceImplTest {
    private Store store;
    private Customer customer;
    private ProductService productService;
    private CustomerService customerService;

    private FileUtil fileUtil = new FileUtil();


    @BeforeEach
    void setup() throws ExecutionException, InterruptedException, IOException {
        store = new Store();
        fileUtil.readProducts();
        productService = new ProductServiceImpl(new FileUtil());
        productService.addingProductToStoreProducts(store).get();
        customerService = new CustomerServiceImpl();

    }

    @Test
    void buyProductShouldReturnSoldAndReceipt() {
        customer = setUpCustomer(2002, "John", "Martins",
                234009987677L, Gender.MALE, "jon@gmail.com", 20000.00, new ArrayList<>());
        Assertions.assertEquals("Product Successfully added to Cart",
                customerService.buyProduct(customer, store, "Salt",5));
    }

    @Test
    void buyProductShouldThrowExceptionWhenProductIsOutOfStock() {
        customer = setUpCustomer(2002, "Mark", "Anthony", 234009987677L,
                Gender.MALE, "jon@gmail.com", 60000.00, new ArrayList<>());
        Assertions.assertThrows(ProductException.class, ()->
                        customerService.buyProduct(customer, store, "Milk",3), "OUT OF STOCK");
    }
    @Test
    void buyProductShouldThrowExceptionWhenProductInStockIsLessThanCustomerRequest() {
        customer = setUpCustomer(2002, "Mark", "Anthony", 234009987677L,
                Gender.MALE, "jon@gmail.com", 60000.00, new ArrayList<>());
        Assertions.assertThrows(ProductException.class, ()->
                customerService.buyProduct(customer, store, "Salt",70), "Product Quantity not Enough");
    }

    @Test
    void shouldThrowItemNotInStoreWhenCustomerSearchForProductNotInStore(){
         customer = setUpCustomer(2002, "Mary", "Rose", 23400998777L,
                Gender.FEMALE, "jona@gmail.com", 20000.00, new ArrayList<>());
        Assertions.assertThrows(ItemNotInStoreException.class, ()->
                customerService.buyProduct(customer, store, "Mango",2), "Product not found");
    }
    private Customer setUpCustomer(Integer id, String firstName, String lastName, Long phoneNo, Gender gender, String email,
                                   double walletBalance, ArrayList<Product> cart) {
        return new Customer(id, firstName, lastName, phoneNo, gender, email, walletBalance, cart);
    }
}