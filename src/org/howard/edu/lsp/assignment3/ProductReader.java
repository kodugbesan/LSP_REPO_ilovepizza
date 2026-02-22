package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads product data from a CSV file and converts
 * each valid row into a Product object.
 */
public class ProductReader {

    /**
     * Reads products from the given file path.
     *
     * @param filePath relative path to input CSV file
     * @return list of Product objects
     * @throws IOException if file cannot be read
     */
    public List<Product> readProducts(String filePath) throws IOException {

        List<Product> products = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        // Skip header
        reader.readLine();

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");

            if (parts.length != 4) {
                continue;
            }

            String id = parts[0].trim();
            String name = parts[1].trim();
            String priceString = parts[2].trim();
            String category = parts[3].trim();

            double price;

            try {
                price = Double.parseDouble(priceString);
            } catch (NumberFormatException e) {
                System.out.println("Skipping invalid price: " + priceString);
                continue;
            }

            products.add(new Product(id, name, price, category));
        }

        reader.close();

        return products;
    }
}