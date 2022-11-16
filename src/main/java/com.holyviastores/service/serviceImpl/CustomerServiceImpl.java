package com.holyviastores.service.serviceImpl;

import com.holyviastores.exceptions.ItemNotInStoreException;
import com.holyviastores.exceptions.ProductException;
import com.holyviastores.model.Customer;
import com.holyviastores.model.Product;
import com.holyviastores.model.Store;
import com.holyviastores.service.CustomerService;

import java.util.List;


public class CustomerServiceImpl implements CustomerService {
    @Override
    public String buyProduct(Customer customer, Store store, String name, int quantity) {
            Product itemFound = searchForItemToPurchase(store, name);
            if (itemFound.getQuantity() < 1) {
                throw new ProductException("OUT OF STOCK");
            } if (itemFound.getQuantity() < quantity) {
                throw new ProductException("Product Quantity not Enough");
            } else {
                synchronized (this) {
                        Product productPurchased = new Product(itemFound.getId(), itemFound.getName(), itemFound.getCategory(),
                                itemFound.getPrice(), itemFound.getDateAdded(), quantity);
                        customer.getCart().add(productPurchased);
                        System.out.println(Thread.currentThread().getName());
                        System.out.println(customer.getFirstName() + " " + customer.getCart());
                        itemFound.setQuantity(itemFound.getQuantity() - quantity);
                }
                    return "Product Successfully added to Cart";
            }
    }

    private Product searchForItemToPurchase(Store store, String name) {
        for (Product products:store.getProductList() )
        {
            if(products.getName().equalsIgnoreCase(name)){
                return products;
            }
        }throw new ItemNotInStoreException("Product not found");
    }
}
