package org.howard.edu.lsp.midterm.strategy;

/**
 * Member customer strategy (10% discount).
 */
public class MemberStrategy implements PriceStrategy {

    @Override
    public double calculatePrice(double price) {
        return price * 0.90;
    }
}