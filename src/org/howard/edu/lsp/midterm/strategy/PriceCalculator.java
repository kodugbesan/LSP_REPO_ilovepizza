package org.howard.edu.lsp.midterm.strategy;

/**
 * Context class that uses a pricing strategy.
 */
public class PriceCalculator {

    private PriceStrategy strategy;

    public void setStrategy(PriceStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculatePrice(double price) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set");
        }
        return strategy.calculatePrice(price);
    }
}