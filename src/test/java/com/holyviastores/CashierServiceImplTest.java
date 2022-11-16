package com.holyviastores;

import com.holyviastores.enums.Certification;
import com.holyviastores.enums.Gender;
import com.holyviastores.enums.Qualification;
import com.holyviastores.exceptions.EmptyCartException;
import com.holyviastores.exceptions.EmptyQueueException;
import com.holyviastores.exceptions.InsufficientFundsException;
import com.holyviastores.model.*;
import com.holyviastores.service.CashierService;
import com.holyviastores.service.ProductService;
import com.holyviastores.service.serviceImpl.CashierServiceImpl;
import com.holyviastores.service.serviceImpl.ProductServiceImpl;
import com.holyviastores.util.FileUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


class CashierServiceImplTest {
    private Store store;
    private Customer customer1;
    private Customer customer2;
    private CashierService cashierService;
    private Product product1;
    private Product product2;

    @BeforeEach
    void setup() {
        store = new Store();
        cashierService = new CashierServiceImpl();
        Cashier cashier = new Cashier(1432, "Matthew", "Shawn", 2345678432L, Gender.MALE,
                "matt@gmail.com", Qualification.BSC, Certification.ICAN);
        cashier.toString();
        product1 = new Product(103, "Salt", "spices", 150, "04/09/2022", 2);
        customer1 = new Customer(2002, "John", "Martins", 234009987677L,
                Gender.MALE, "jon@gmail.com", 4000.00, new ArrayList<>());
        customer2 = new Customer(2002, "Mark", "Anthony",
                234009987677L, Gender.MALE, "jon@gmail.com", 30000.00, new ArrayList<>());
        cashierService.toString();
        ProductService productService = new ProductServiceImpl(new FileUtil());
        productService.addingProductToStoreProducts(store);
    }

    @Test
    void validateCustomerCartShouldThrowEmptyCartException() {
        customer1.getCart();
        Assertions.assertThrows(EmptyCartException.class, () -> cashierService.sellProduct(customer1),
                "You need to add items to your Cart");
    }

    @Test
    void validateCustomerCartThrowInsufficientFundsIfWalletAmountIsSmall() {
        customer2 = new Customer(2002, "Mark", "Anthony",
                234009987677L, Gender.MALE, "jon@gmail.com", 100.00, new ArrayList<>());
        customer2.getCart().add(product1);
        Assertions.assertThrows(InsufficientFundsException.class, () -> cashierService.sellProduct(customer2),
                "Insufficient Funds");
    }
    @Test
    void sellProductShouldReturnPurchaseSuccessfulIfTotalPriceOfItemsIsLesserThanWalletAmount() {
        customer1.getCart().add(product1);
        Assertions.assertEquals("Thank you for shopping with us successfully", cashierService.sellProduct(customer1));
    }
    @Test
    void sellProductByQuantityPriority_ShouldReturnPurchaseSuccessful() {
        product2 = new Product(103, "Salt", "spices", 2500, "04/09/2022", 10);
        customer1.getCart().add(product1);
        customer2.getCart().add(product2);
        store.getQueueList().add(customer1);
        store.getQueueList().add(customer2);
        validateCustomerCart(customer1);
        Assertions.assertEquals("Purchase successful, Thank you",
                cashierService.sellProductByQuantity(store));
    }

    @Test
    void sellProductByFirstInFirstOut_ShouldReturnPurchaseSuccessful() {
        product2 = new Product(103, "Salt", "spices", 2500, "04/09/2022", 2);
        customer1.getCart().add(product1);
        customer2.getCart().add(product2);
        store.getFifo().add(customer1);
        store.getFifo().add(customer2);
        Assertions.assertEquals("Thank you for shopping with us successfully",
                cashierService.sellByFirstInFirstOut(store));
    }

    @Test
    void sellProductByQuantityPriority_ShouldThrowExceptionIfQueueIsEmpty() {
        store.getQueueList();
        Assertions.assertThrows(EmptyQueueException.class, () ->
                cashierService.sellProductByQuantity(store), "There are no customers on the queue");
    }

    @Test
    void sellProductByFirstInFistOut_ShouldThrowExceptionIfQueueIsEmpty() {
        store.getFifo();
        Assertions.assertThrows(EmptyQueueException.class, () ->
                cashierService.sellByFirstInFirstOut(store), "There are no customers on the queue");
    }

    @Test
    void dispenseReceiptShouldReturnCustomerReceipt() {
        Customer customer1 = new Customer(2002, "John", "Martins", 234009987677L,
                Gender.MALE, "jon@gmail.com", 5000.00, new ArrayList<>());
        String receipt = "====================== PURCHASE RECEIPT ====================== \n" +
                "Name ===============" + customer1.getFirstName() + "\n" +
                "---------------------------------------------------- \n" +
                "Total ============== " + getPriceOfItemsInCustomersCart(customer1) + "\n" +
                "---------------------------------------------------- \n" +
                "Thanks for shopping with us";
        Assertions.assertEquals(receipt, cashierService.dispenseReceipt(customer1));
    }

    private double getPriceOfItemsInCustomersCart(Customer customer) {
        double total = 0;
        for (Product product : customer.getCart()) {
            total += (product.getPrice() * product.getQuantity());
        }
        return total;
    }
    private void validateCustomerCart(Customer customer) {
        if (customer.getCart().isEmpty()) {
            System.out.println("Cart is empty");
            throw new EmptyCartException("You need to add items to your Cart");
        }
        if (getPriceOfItemsInCustomersCart(customer) > customer.getWalletBalance()) {
            System.out.println("Insufficient Balance");
            throw new InsufficientFundsException("Insufficient Balance");
        }
    }
}