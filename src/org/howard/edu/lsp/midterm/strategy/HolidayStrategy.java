package org.howard.edu.lsp.midterm.strategy;

/**
 * Holiday customer strategy (15% discount).
 */
public class HolidayStrategy implements PriceStrategy {

    @Override
    public double calculatePrice(double price) {
        return price * 0.85;
    }
}