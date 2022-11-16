package com.holyviastores.util;

import com.holyviastores.model.Product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileUtil {

    private final List<Product> itemsAvailableInStore = new ArrayList<>();
    File file;



    public FileUtil() {
    }
    public List<Product> getItemsAvailableInStore() {
        return itemsAvailableInStore;
    }

    public FileUtil(File file) {

        this.file = file;
    }

    public void readProducts() throws IOException {
        file = new File("src/main/resources/ItemsInStore");
        Scanner readFile = new Scanner(file);
        StringTokenizer token1;
         int id;
         String name;
         String category;
         double price;
         String dateAdded;
         int quantity;
         while(readFile.hasNextLine()){
             token1 = new StringTokenizer(readFile.nextLine(), ",");
             id = Integer.parseInt(token1.nextToken());
             name = token1.nextToken();
             category = token1.nextToken();
             price = Double.parseDouble(token1.nextToken());
             dateAdded = token1.nextToken();
             quantity = Integer.parseInt(token1.nextToken());
             Product product = new Product(id, name, category, price, dateAdded, quantity);
             itemsAvailableInStore.add(product);
         }
    }
}
