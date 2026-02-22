package org.howard.edu.lsp.assignment3;

import java.io.IOException;
import java.util.List;

/**
 * Main class that runs the ETL pipeline for Assignment 3.
 */
public class ETLPipeline {

    /**
     * Entry point of the program.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) throws IOException {

        ProductReader reader = new ProductReader();
        ProductTransformer transformer = new ProductTransformer();
        ProductWriter writer = new ProductWriter();

        List<Product> products = reader.readProducts("data/products.csv");

        List<Product> transformedProducts = transformer.transform(products);

        writer.write(transformedProducts);
    }
}