The current PriceCalculator class relies on several conditional statements to determine the final price based on the customer type. This makes the design difficult to extend because adding a new customer category would require modifying the existing method, which goes against good design principles like the Open/Closed Principle.

In addition, having all the pricing logic inside a single method reduces maintainability. The class ends up handling multiple responsibilities, and the logic for different customer types is tightly coupled together.

A better approach would be to use the Strategy Pattern, where each pricing behavior is separated into its own class. This allows new customer types to be added without changing existing code, making the system easier to extend and maintain.