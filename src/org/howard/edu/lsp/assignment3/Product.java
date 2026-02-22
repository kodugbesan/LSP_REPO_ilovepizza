package org.howard.edu.lsp.assignment3;

/**
 * Represents a product record from the CSV file.
 * Stores product attributes and allows controlled access
 * through getter methods.
 */
public class Product {

    private String id;
    private String name;
    private double price;
    private String category;

    /**
     * Constructs a Product object.
     *
     * @param id product ID
     * @param name product name
     * @param price product price
     * @param category product category
     */
    public Product(String id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}