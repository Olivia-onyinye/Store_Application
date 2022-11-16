package com.holyviastores.service;

import com.holyviastores.model.Store;
import java.util.concurrent.CompletableFuture;

public interface ProductService{
    CompletableFuture<String> addingProductToStoreProducts(Store store);
}
