package com.nano1.salestaxes.intelij;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

/**
 * Created by nano1 on 4/6/2016.
 */
public class ShoppingCart {

    private final List<ShoppingCartItem> shoppingCartItems = new ArrayList<>();

    public void add(ShoppingCartItem shoppingCartItem){
       if (checkDuplicate(shoppingCartItem)) {

       }else {
           shoppingCartItems.add(shoppingCartItem);
       }
    }

    public boolean checkDuplicate(ShoppingCartItem item){
        boolean isDuplicate = false;
        for (ShoppingCartItem shoppingCartItem : shoppingCartItems){
           if (shoppingCartItem.getName().equals(item.getName())){
                isDuplicate = true;
               shoppingCartItem.addQuantity(1);
           }
        }
        return isDuplicate;
    }

    public List<ShoppingCartItem> getProducts() {
        return shoppingCartItems;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal total = BigDecimal.ZERO;
        for (ShoppingCartItem shoppingCartItem : shoppingCartItems){
            total = total.add(shoppingCartItem.getSellingPrice().multiply(new BigDecimal(shoppingCartItem.getQuantity())));
        }
        return total;
    }

    public BigDecimal getTotalTax() {
        BigDecimal total = BigDecimal.ZERO;
        for (ShoppingCartItem shoppingCartItem : shoppingCartItems){
            total = total.add(shoppingCartItem.calculateTax().multiply(new BigDecimal(shoppingCartItem.getQuantity())));
        }
        return total;
    }

    public int size(){
        return shoppingCartItems.size();
    }

    public String printReceipt() {
        final StringBuilder formatted = new StringBuilder();

        final NumberFormat numberFormat = new DecimalFormat("#,##0.00");
        for (final ShoppingCartItem shoppingCartItem : shoppingCartItems) {
            formatted.append(shoppingCartItem.toString());
            formatted.append("\n");
        }
        formatted.append("Sales Taxes:").append(String.format("%18s%n", numberFormat.format(getTotalTax())));
        formatted.append("Total:").append(String.format("%24s%n", numberFormat.format(getTotalPrice())));
        formatted.append("--------------------------------");

        return formatted.toString();
    }

    @Override
    public String toString() {
        return printReceipt();
    }
}
