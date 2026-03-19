package org.howard.edu.lsp.midterm.strategy;

/**
 * Driver to test Strategy Pattern implementation.
 */
public class Driver {

    public static void main(String[] args) {

        double price = 100.0;
        PriceCalculator calculator = new PriceCalculator();

        calculator.setStrategy(new RegularStrategy());
        System.out.println("REGULAR: " + calculator.calculatePrice(price));

        calculator.setStrategy(new MemberStrategy());
        System.out.println("MEMBER: " + calculator.calculatePrice(price));

        calculator.setStrategy(new VipStrategy());
        System.out.println("VIP: " + calculator.calculatePrice(price));

        calculator.setStrategy(new HolidayStrategy());
        System.out.println("HOLIDAY: " + calculator.calculatePrice(price));
    }
}