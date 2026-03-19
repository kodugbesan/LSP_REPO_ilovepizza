package org.howard.edu.lsp.midterm.strategy;

/**
 * VIP customer strategy (20% discount).
 */
public class VipStrategy implements PriceStrategy {

    @Override
    public double calculatePrice(double price) {
        return price * 0.80;
    }
}