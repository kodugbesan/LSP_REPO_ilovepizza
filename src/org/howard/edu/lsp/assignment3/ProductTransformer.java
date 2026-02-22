package org.howard.edu.lsp.assignment3;

import java.util.ArrayList;
import java.util.List;

/**
 * Applies transformation rules to product data.
 */
public class ProductTransformer {

    /**
     * Transforms products according to assignment rules.
     *
     * @param products list of original products
     * @return list of transformed products
     */
    public List<Product> transform(List<Product> products) {

        List<Product> transformed = new ArrayList<>();

        for (Product product : products) {

            // Skip products with price <= 0
            if (product.getPrice() <= 0) {
                continue;
            }

            String newName = product.getName().toUpperCase();
            double newPrice = product.getPrice() * 1.10; // 10% increase

            Product updated = new Product(
                    product.getId(),
                    newName,
                    newPrice,
                    product.getCategory()
            );

            transformed.add(updated);
        }

        return transformed;
    }
}