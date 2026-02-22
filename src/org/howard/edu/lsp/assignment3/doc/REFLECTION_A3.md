# Assignment 3 Reflection

## Design Overview

For Assignment 3, I refactored my Assignment 2 procedural program into a more object-oriented design. I separated the responsibilities into multiple classes:

- Product: Represents a product with id, name, price, and category.
- ProductReader: Handles reading product data from the CSV file.
- ProductTransformer: Applies transformation logic to product data.
- ProductWriter: Writes transformed products to an output file.
- ETLPipeline: Orchestrates the overall ETL (Extract, Transform, Load) process.

This separation improves modularity and follows the Single Responsibility Principle.

## Improvements Over Assignment 2

In Assignment 2, all logic was contained in one main class. In Assignment 3, I distributed responsibilities across dedicated classes, making the system easier to understand, test, and maintain.

The ETLPipeline class coordinates the workflow while other classes focus on their specific tasks. This makes the code more organized and scalable.

## Error Handling

I improved error handling by catching invalid numeric values when parsing product prices. If a row contains an invalid price (e.g., "abc"), the program skips that row instead of crashing.

This ensures robustness and prevents runtime exceptions from stopping execution.

## Challenges

One challenge was ensuring the updated compiled classes were being used after modifying the source files. I resolved this by deleting the bin directory and recompiling the project.

I also encountered issues with package structure, which I fixed by ensuring the directory structure matched the declared package.

## Conclusion

Overall, this assignment strengthened my understanding of object-oriented design, modularization, and structured program organization. Refactoring procedural logic into separate classes improved code clarity and maintainability.
