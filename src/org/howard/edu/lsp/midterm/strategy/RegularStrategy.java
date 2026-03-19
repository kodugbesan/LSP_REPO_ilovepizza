package org.howard.edu.lsp.midterm.strategy;

/**
 * Regular customer strategy (no discount).
 */
public class RegularStrategy implements PriceStrategy {

    @Override
    public double calculatePrice(double price) {
        return price;
    }
}