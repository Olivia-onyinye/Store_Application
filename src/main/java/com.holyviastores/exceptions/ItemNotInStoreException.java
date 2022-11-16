package com.holyviastores.exceptions;

public class ItemNotInStoreException extends RuntimeException {
    public ItemNotInStoreException(String product_not_found) {
        super(product_not_found);
    }
}
