# Improved Design Using CRC Cards

## Class: Order
Responsibilities:
- Store order information such as customer name, email, item, and price
- Provide access to order data

Collaborators:
- OrderProcessor
- PricingService

---

## Class: OrderProcessor
Responsibilities:
- Coordinate the overall order processing workflow
- Delegate tasks to other components such as pricing, storage, and notification

Collaborators:
- Order
- PricingService
- ReceiptService
- EmailService
- OrderRepository
- Logger

---

## Class: PricingService
Responsibilities:
- Calculate tax for an order
- Apply discounts based on business rules
- Compute final total

Collaborators:
- Order

---

## Class: ReceiptService
Responsibilities:
- Generate and format receipts for orders
- Handle receipt output (e.g., display or prepare for storage)

Collaborators:
- Order

---

## Class: OrderRepository
Responsibilities:
- Persist order data to storage (e.g., file or database)
- Retrieve stored orders if needed

Collaborators:
- Order

---

## Class: EmailService
Responsibilities:
- Send confirmation emails to customers
- Handle email formatting and delivery

Collaborators:
- Order

---

## Class: Logger
Responsibilities:
- Log system activity such as order processing timestamps and events

Collaborators:
- OrderProcessor