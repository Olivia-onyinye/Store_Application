package com.holyviastores;

import com.holyviastores.model.Store;
import com.holyviastores.service.ProductService;
import com.holyviastores.service.serviceImpl.ProductServiceImpl;
import com.holyviastores.util.FileUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


class ProductServiceImplTest {

    @Test
    void addingProductToStoreProductsShouldBeSuccessful() throws ExecutionException, InterruptedException {
        Store store = new Store();
        ProductService productService = new ProductServiceImpl(new FileUtil());
        FileUtil pr = new FileUtil();
        CompletableFuture<String> message =  productService.addingProductToStoreProducts(store);
        Assertions.assertEquals("Items have been added to Store", message.get());
    }
}