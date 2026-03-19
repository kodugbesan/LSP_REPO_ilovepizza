I used ChatGPT to help me understand how to apply the Strategy Pattern and how to organize the solution into separate classes. It helped me see how to replace conditional statements with polymorphism and how to structure the code using different strategy classes along with a central context class.

This guidance helped me implement the refactored design correctly and produce the expected output for the different customer types.


PROMPT: 
Question 3 - Refactoring to Use a Design Pattern (30 points) The following class calculates final prices for customer purchases. Although the code works, the design makes the system difficult to extend and maintain. Study the code carefully and answer the questions that follow. Provided Class package org.howard.edu.lsp.midterm.strategy; public class PriceCalculator { public double calculatePrice(String customerType, double price) { double finalPrice = price; if (customerType.equals("REGULAR")) { finalPrice = price; } if (customerType.equals("MEMBER")) { finalPrice = price * 0.90; } if (customerType.equals("VIP")) { finalPrice = price * 0.80; } if (customerType.equals("HOLIDAY")) { finalPrice = price * 0.85; } return finalPrice; } } Part 1 - Design Evaluation (8 points) Evaluate the design of the PriceCalculator class. Explain why the current implementation may lead to maintenance or extensibility problems as the system evolves. Your answer must be written in a Markdown file named: design_evaluation.md Place the file in the package: org.howard.edu.lsp.midterm.strategy.doc Part 2 - Refactoring Using a Design Pattern (10 points) Refactor the provided design to use the Strategy Pattern discussed during lecture. Your refactored implementation must be placed in the package: org.howard.edu.lsp.midterm.strategy Each class must be placed in its own .java file. Your implementation should demonstrate the use of the Strategy design pattern to support different discount behaviors. All classes and public methods must include Javadoc comments. Part 3 - Driver Program (5 points) Create a Driver class that demonstrates that your Strategy Pattern implementation works correctly. Your Driver class must be placed in the package: org.howard.edu.lsp.midterm.strategy Your driver must demonstrate the following cases using a purchase price of 100.0: • REGULAR customer • MEMBER customer • VIP customer • HOLIDAY customer Your driver must produce output in the following format: REGULAR: 100.0 MEMBER: 90.0 VIP: 80.0 HOLIDAY: 85.0 The output must be produced by executing your Strategy-based implementation, not by hardcoding the results. Part 4 - Development Log (5 points) Create a Markdown file named development_log_q3.md Place the file in the package: org.howard.edu.lsp.midterm.strategy.doc This file must document any external resources used while completing this question, including AI tools, internet searches, documentation, lecture notes, or textbooks. For each resource used, include what you searched or asked and how the information helped you complete the problem. If no external assistance was used, clearly state that in the file. Grading Rubric (30 points) Component Points Design evaluation (design_evaluation.md) 8 Correct refactoring using Strategy Pattern 10 Driver execution and required output 5 Javadoc documentation in classes and public methods 2 Development log documenting AI/internet use 5

RESPONSE:
Good—this question is very structured, but it can feel overwhelming until you see the pattern. I’ll break it down plainly and step-by-step, so you know exactly what the professor expects and what you actually need to do.

🧠 Big Picture (What this question is about)

You are given a class:

👉 PriceCalculator

It uses a bunch of if statements to decide pricing based on customerType.

Your job is to:

Critique why this design is bad

Refactor it using the Strategy Pattern

Prove it works with a Driver

Document your resources

🔹 Step 1: Understand the problem in the code

Current logic:

if (customerType.equals("REGULAR")) ...
if (customerType.equals("MEMBER")) ...
if (customerType.equals("VIP")) ...
if (customerType.equals("HOLIDAY")) ...

👉 This means:

One class is handling all pricing logic

It uses hardcoded conditionals

Every time a new customer type is added, you must edit this class

🔹 Step 2: What the question is asking (Part by Part)
✅ Part 1 — Design Evaluation

You need to answer:

👉 Why is this design bad?

Think in terms of OOP principles:

Not extensible

Violates Open/Closed Principle

Uses conditional logic instead of polymorphism

Hard to maintain

Tightly coupled logic in one class

📄 Output file:

org/howard/edu/lsp/midterm/strategy/doc/design_evaluation.md
✅ Part 2 — Refactor Using Strategy Pattern

This is the core of the assignment.

Instead of if statements, you will:

👉 Replace conditionals with separate classes for each pricing strategy

💡 Strategy Pattern Idea

Instead of:

if (VIP) → 20% off

You create:

VIPStrategy

MemberStrategy

RegularStrategy

HolidayStrategy

Each class handles its own pricing logic.

🧱 What classes you need

You will create:

1. Strategy Interface

Defines a common method:

calculatePrice(double price)

2. Concrete Strategy Classes

Each one implements the interface:

Regular strategy → no discount

Member strategy → 10% off

VIP strategy → 20% off

Holiday strategy → 15% off

3. Context Class (PriceCalculator)

Holds a reference to a strategy

Uses the strategy to calculate price

No more if statements

🔁 Flow becomes:
Driver → selects strategy → PriceCalculator uses it → returns result

📁 All of this goes in:

org/howard/edu/lsp/midterm/strategy
✅ Part 3 — Driver Program

You must create a Driver.java that:

Tests all 4 customer types

Uses your Strategy classes

Uses a base price of 100.0

Expected output:
REGULAR: 100.0
MEMBER: 90.0
VIP: 80.0
HOLIDAY: 85.0

⚠️ Important:

You must NOT hardcode these numbers

They must come from your strategy classes

✅ Part 4 — Development Log

You document:

ChatGPT usage

Any searches or notes used

What you asked and how it helped

📄 File:

org/howard/edu/lsp/midterm/strategy/doc/development_log_q3.md
🔹 Step-by-step execution plan (what YOU should do)
Step 1: Create packages

Make sure you have:

org/howard/edu/lsp/midterm/strategy
org/howard/edu/lsp/midterm/strategy/doc
Step 2: Write evaluation.md

Explain:

Why if-statements are bad

Why it's not extensible

Why Strategy Pattern is better

Step 3: Implement Strategy Pattern

You will create:

PriceStrategy (interface)

RegularStrategy

MemberStrategy

VipStrategy

HolidayStrategy

Updated PriceCalculator

Driver.java

Step 4: Run Driver

Make sure output matches exactly.

Step 5: Write development log
🔥 Key Concept to Remember

This question is testing whether you understand:

👉 Replacing conditionals with polymorphism

Instead of:

if (type == VIP)

You do:

strategy.calculatePrice()
👍 If you want next

I can walk you through this in a very structured way like before:

Step-by-step implementation of Strategy Pattern

Provide full code files (clean, submission-ready)

Help you avoid common mistakes

Help you match exact professor expectations

Just tell me:
👉 “start implementation”

PROMPT: START IMPLEMENTATION

RESPONSE:
Great — we’ll implement this cleanly step-by-step, but I’ll still keep it structured so you understand what each piece is doing (not just copy/paste blindly).

We’re implementing the Strategy Pattern.

🧱 Step 1: Create the Strategy Interface

📄 File:

org/howard/edu/lsp/midterm/strategy/PriceStrategy.java
package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy interface for calculating price based on customer type.
 */
public interface PriceStrategy {

    /**
     * Calculates the final price based on a base price.
     *
     * @param price the original price
     * @return the final calculated price
     */
    double calculatePrice(double price);
}
🧱 Step 2: Create Concrete Strategy Classes

Each customer type gets its own class.

✅ Regular Strategy

📄 RegularStrategy.java

package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for REGULAR customers (no discount).
 */
public class RegularStrategy implements PriceStrategy {

    @Override
    public double calculatePrice(double price) {
        return price;
    }
}
✅ Member Strategy

📄 MemberStrategy.java

package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for MEMBER customers (10% discount).
 */
public class MemberStrategy implements PriceStrategy {

    @Override
    public double calculatePrice(double price) {
        return price * 0.90;
    }
}
✅ VIP Strategy

📄 VipStrategy.java

package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for VIP customers (20% discount).
 */
public class VipStrategy implements PriceStrategy {

    @Override
    public double calculatePrice(double price) {
        return price * 0.80;
    }
}
✅ Holiday Strategy

📄 HolidayStrategy.java

package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for HOLIDAY customers (15% discount).
 */
public class HolidayStrategy implements PriceStrategy {

    @Override
    public double calculatePrice(double price) {
        return price * 0.85;
    }
}
🧱 Step 3: Refactor PriceCalculator (Context Class)

📄 File:

PriceCalculator.java

Replace your original logic with this:

package org.howard.edu.lsp.midterm.strategy;

/**
 * Context class that uses a PriceStrategy to calculate final price.
 */
public class PriceCalculator {

    private PriceStrategy strategy;

    /**
     * Sets the pricing strategy.
     *
     * @param strategy the strategy to use
     */
    public void setStrategy(PriceStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Calculates the final price using the selected strategy.
     *
     * @param price the original price
     * @return the final calculated price
     */
    public double calculatePrice(double price) {
        if (strategy == null) {
            throw new IllegalStateException("Price strategy not set");
        }
        return strategy.calculatePrice(price);
    }
}
🧱 Step 4: Create Driver Class

📄 File:

Driver.java
package org.howard.edu.lsp.midterm.strategy;

/**
 * Driver class to demonstrate Strategy Pattern usage.
 */
public class Driver {

    public static void main(String[] args) {

        double price = 100.0;

        PriceCalculator calculator = new PriceCalculator();

        // REGULAR
        calculator.setStrategy(new RegularStrategy());
        System.out.println("REGULAR: " + calculator.calculatePrice(price));

        // MEMBER
        calculator.setStrategy(new MemberStrategy());
        System.out.println("MEMBER: " + calculator.calculatePrice(price));

        // VIP
        calculator.setStrategy(new VipStrategy());
        System.out.println("VIP: " + calculator.calculatePrice(price));

        // HOLIDAY
        calculator.setStrategy(new HolidayStrategy());
        System.out.println("HOLIDAY: " + calculator.calculatePrice(price));
    }
}
✅ What you should see when you run:
REGULAR: 100.0
MEMBER: 90.0
VIP: 80.0
HOLIDAY: 85.0
🔥 Important Things to Double-Check

All files are in:

org/howard/edu/lsp/midterm/strategy

Interface + classes all compiled

No typos in package names

Driver runs successfully

🧠 Why this works (quick intuition)

Instead of:

if (type == "VIP") ...

You now do:

strategy.calculatePrice()

👉 Behavior is “plugged in” instead of hardcoded
👉 This is exactly what Strategy Pattern is for