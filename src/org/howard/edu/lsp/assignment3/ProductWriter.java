package org.howard.edu.lsp.assignment3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Writes transformed products to a CSV file.
 */
public class ProductWriter {

    /**
     * Writes products to the output CSV file.
     *
     * @param products list of transformed products
     */
    public void write(List<Product> products) {

        try (FileWriter writer = new FileWriter("data/transformed_products.csv")) {

            writer.write("ProductID,Name,Price,Category\n");

            for (Product product : products) {
                writer.write(
                        product.getId() + "," +
                        product.getName() + "," +
                        product.getPrice() + "," +
                        product.getCategory() + "\n"
                );
            }

            System.out.println("Output written to data/transformed_products.csv");

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}