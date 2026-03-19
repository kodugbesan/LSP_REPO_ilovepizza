# Design Evaluation of OrderProcessor

The OrderProcessor class violates several object-oriented design principles and demonstrates poor separation of concerns.

First, the class lacks proper encapsulation. All data fields (customerName, email, item, and price) are declared as public, allowing external code to directly access and modify them. This breaks the principle of data hiding and can lead to unintended side effects and reduced control over the object's state.

Second, the class has multiple responsibilities within a single method. The processOrder() method handles tax calculation, receipt printing, file writing, email notification, discount application, and logging. This violates the Single Responsibility Principle because the class is responsible for too many unrelated tasks. As a result, the code becomes harder to maintain, test, and modify.

Additionally, the design is not easily extensible. For example, if the way emails are sent or receipts are stored changes, modifications would need to be made directly inside this class. This tightly couples multiple functionalities together, making it difficult to reuse or extend individual components independently.

Finally, the class mixes business logic with input/output operations such as file handling and console printing. This further reduces modularity and makes the system harder to scale or adapt. A better design would separate these concerns into distinct classes with clearly defined responsibilities.