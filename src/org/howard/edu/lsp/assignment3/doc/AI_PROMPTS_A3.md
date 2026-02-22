# AI Prompts – Assignment 3

## Prompt 1

**Prompt I asked:**
How can I redesign my Assignment 2 ETL pipeline to be more object-oriented while keeping the same functionality?

**AI Response (Excerpt):**
You can improve object-oriented design by separating responsibilities into different classes. For example:
- A Product class to represent each product.
- A ProductReader class to handle reading CSV input.
- A ProductTransformer class to apply transformation logic.
- A ProductWriter class to write output to a file.
- An ETLPipeline class to coordinate the workflow.

**How I Used It:**
I redesigned my solution to include separate classes for reading, transforming, and writing data. This improved separation of concerns and made the program more modular compared to Assignment 2.

---

## Prompt 2

**Prompt I asked:**
How can I handle invalid numeric values (like "abc") in a CSV file when parsing double values in Java?

**AI Response (Excerpt):**
Wrap Double.parseDouble() inside a try-catch block. Catch NumberFormatException and skip invalid rows while printing a helpful message.

**How I Used It:**
I implemented a try-catch block inside ProductReader. If a price cannot be parsed, the program prints:
"Skipping invalid price: abc"
and continues processing the remaining rows.

---

## Prompt 3

**Prompt I asked:**
How should my folder structure and package declaration look for org.howard.edu.lsp.assignment3?

**AI Response (Excerpt):**
All files should be placed under:
src/org/howard/edu/lsp/assignment3/
Each Java file must begin with:
package org.howard.edu.lsp.assignment3;

**How I Used It:**
I verified that all Assignment 3 files are located in the correct directory and that each file includes the proper package declaration.

---

## Prompt 4

**Prompt I asked:**
How can I skip CSV rows that have too few or too many fields?

**AI Response (Excerpt):**
Check the number of columns after splitting each line by commas. Skip any row that does not match the expected number of fields and optionally log a message.

**How I Used It:**
In ProductReader, I added a check `if (parts.length != 4) continue;`. Rows with missing or extra fields are skipped, preventing runtime errors.

---

## Prompt 5

**Prompt I asked:**
How can I transform product names to uppercase and calculate a PriceRange based on the price?

**AI Response (Excerpt):**
Create a ProductTransformer class. In it, convert names to uppercase, and add logic to assign a price range based on numeric thresholds.

**How I Used It:**
In ProductTransformer, I applied `product.setName(product.getName().toUpperCase())` and calculated `PriceRange` as Low/Medium/High/Premium. This ensures output matches the required format.

---

## Prompt 6

**Prompt I asked:**
How should I test my ETL pipeline with missing input or empty files?

**AI Response (Excerpt):**
Check if the file is empty before processing. Handle exceptions gracefully and ensure no rows are added if the file has no content.

**How I Used It:**
I ran tests with an empty `products.csv` file and confirmed that no exceptions occur, the program prints informative messages, and `transformed_products.csv` is empty.