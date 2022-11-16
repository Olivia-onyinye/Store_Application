package com.holyviastores.service.serviceImpl;

import com.holyviastores.model.Product;
import com.holyviastores.model.Store;
import com.holyviastores.service.ProductService;
import com.holyviastores.util.FileUtil;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class ProductServiceImpl implements ProductService {
    private final FileUtil fileUtil1;

    public ProductServiceImpl(FileUtil fileUtil){

        this.fileUtil1 = fileUtil;
    }
    @Override
    public CompletableFuture<String> addingProductToStoreProducts(Store store) {
      return  CompletableFuture.supplyAsync(() ->{
            try {
                readingProductFromFileReader(store);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return "Items have been added to Store";
        });
    }

    private void readingProductFromFileReader(Store store) throws IOException{
        fileUtil1.readProducts();
        fileUtil1.getItemsAvailableInStore().stream().map(itemsInProductReader -> new Product(
                itemsInProductReader.getId(),
                itemsInProductReader.getName(),
                itemsInProductReader.getCategory(),
                itemsInProductReader.getPrice(),
                itemsInProductReader.getDateAdded(),
                itemsInProductReader.getQuantity()
        )).forEachOrdered(newItems -> store.getProductList().add(newItems));
    }
}