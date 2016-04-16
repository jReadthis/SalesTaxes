package com.nano1.salestaxes.intelij;

import java.math.BigDecimal;

/**
 * Created by nano1 on 4/7/2016.
 */
public class ShoppingCartItem {

    private String name;
    private BigDecimal originalPrice;
    private TaxCalculator taxCalculator;
    private int quantity;

    public ShoppingCartItem(String name, BigDecimal originalPrice, int quantity, TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
        this.quantity = quantity;
        this.originalPrice = originalPrice;
        this.name = name;
    }

    public ShoppingCartItem(String name, String originalPrice, int quantity, TaxCalculator taxCalculator) {
        this(name, new BigDecimal(originalPrice),quantity,taxCalculator);
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int quantity){
        this.quantity += quantity;
    }

    public String getName() {
        return name;
    }

    public BigDecimal calculateTax(){
        return taxCalculator.calculateTax(originalPrice);
    }

    public BigDecimal getSellingPrice(){
        return originalPrice.add(calculateTax());
    }

    @Override
    public String toString() {
        if (quantity > 1){
            return name + ": " + getSellingPrice().multiply(new BigDecimal(quantity)) +"(" + quantity + " @ "+ getSellingPrice() +")";
        }
        else {
            return name + ": " + getSellingPrice();
        }
    }
}
