The Template Method pattern is used by defining a fixed workflow in the `generateReport()` method inside the `Report` base class. This method calls `loadData()`, `formatHeader()`, `formatBody()`, and `formatFooter()` in a specific order.

Each subclass (`StudentReport` and `CourseReport`) overrides these methods to provide its own implementation, while still following the same overall structure.

This allows the program to reuse the common workflow while allowing different report types to customize specific steps, demonstrating polymorphism and code reuse.