package com.holyviastores.model;

public class Product {
    private int id;
    private String name;
    private String category;
    private double price;
    private String dateAdded;
    private int quantity;

    public Product(int id, String name, String category, double price, String dateAdded, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.dateAdded = dateAdded;
    }

    public int getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public String getCategory() {

        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getDateAdded() {

        return dateAdded;
    }

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", dateAdded=" + dateAdded +
                ", quantity=" + quantity +
                '}';
    }
}
