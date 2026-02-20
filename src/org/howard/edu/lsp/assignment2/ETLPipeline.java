package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ETLPipeline {

    public static void main(String[] args) {

        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        int rowsRead = 0;
        int rowsWritten = 0;
        int rowsSkipped = 0;

        File inputFile = new File(inputPath);

        // Case C: Missing file
        if (!inputFile.exists()) {
            System.out.println("Error: Input file data/products.csv not found.");
            return;
        }

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputPath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))
        ) {

            // Read header
            String header = reader.readLine();

            // Always write output header
            writer.write("ProductID,Name,Price,Category,PriceRange");
            writer.newLine();

            // Case B: Empty file (header only)
            if (header == null) {
                System.out.println("Input file is empty.");
                System.out.println("Rows Read: 0");
                System.out.println("Rows Transformed: 0");
                System.out.println("Rows Skipped: 0");
                System.out.println("Output written to: " + outputPath);
                return;
            }

            String line;

            while ((line = reader.readLine()) != null) {

                rowsRead++;

                // Skip blank lines
                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                String[] parts = line.split(",");

                // Must have exactly 4 fields
                if (parts.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                try {
                    String productIdStr = parts[0].trim();
                    String name = parts[1].trim();
                    String priceStr = parts[2].trim();
                    String category = parts[3].trim();

                    int productId = Integer.parseInt(productIdStr);
                    BigDecimal price = new BigDecimal(priceStr);

                    // 1) Uppercase name
                    name = name.toUpperCase();

                    String originalCategory = category;

                    // 2) Apply 10% discount if Electronics
                    if (originalCategory.equals("Electronics")) {
                        price = price.multiply(new BigDecimal("0.90"));
                    }

                    // Round to two decimals (round-half-up)
                    price = price.setScale(2, RoundingMode.HALF_UP);

                    // 3) Premium Electronics rule
                    if (price.compareTo(new BigDecimal("500.00")) > 0
                            && originalCategory.equals("Electronics")) {
                        category = "Premium Electronics";
                    }

                    // 4) Determine PriceRange
                    String priceRange;

                    if (price.compareTo(new BigDecimal("10.00")) <= 0) {
                        priceRange = "Low";
                    } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
                        priceRange = "Medium";
                    } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
                        priceRange = "High";
                    } else {
                        priceRange = "Premium";
                    }

                    // Write output
                    writer.write(productId + "," + name + "," +
                            price.toString() + "," +
                            category + "," +
                            priceRange);
                    writer.newLine();

                    rowsWritten++;

                } catch (Exception e) {
                    // Skip rows with parsing errors
                    rowsSkipped++;
                }
            }

        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
            return;
        }

        // Print summary
        System.out.println("Rows Read: " + rowsRead);
        System.out.println("Rows Transformed: " + rowsWritten);
        System.out.println("Rows Skipped: " + rowsSkipped);
        System.out.println("Output written to: " + outputPath);
    }
}