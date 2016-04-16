package com.nano1.salestaxes.intelij;

import org.junit.Assert;
import java.math.BigDecimal;

/**
 * Created by nano1 on 4/7/2016.
 */

public class Test {

    @org.junit.Test
    public void Test1(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new ItemBuilder(1, new Product("book",new BigDecimal("12.49"))).build());
        shoppingCart.add(new ItemBuilder(1, new Product("book",new BigDecimal("12.49"))).build());
        shoppingCart.add(new ItemBuilder(1, new Product("music CD",new BigDecimal("14.99"))).addSalesTaxCalc().build());
        shoppingCart.add(new ItemBuilder(1, new Product("chocolate bar",new BigDecimal("0.85"))).build());

        Assert.assertEquals(new BigDecimal("1.50"), shoppingCart.getTotalTax());
        Assert.assertEquals(new BigDecimal("42.32"), shoppingCart.getTotalPrice());
    }

    @org.junit.Test
    public void Test2(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new ItemBuilder(1, new Product("imported box of chocolates",new BigDecimal("10.00"))).addImportTaxCalc().build());
        shoppingCart.add(new ItemBuilder(1, new Product("imported bottle of perfume",new BigDecimal("47.50"))).addImportTaxCalc().addSalesTaxCalc().build());

        Assert.assertEquals(new BigDecimal("7.65"), shoppingCart.getTotalTax());
        Assert.assertEquals(new BigDecimal("65.15"), shoppingCart.getTotalPrice());
    }

    @org.junit.Test
    public void Test3(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new ItemBuilder(1, new Product("imported bottle of perfume",new BigDecimal("27.99"))).addImportTaxCalc().addSalesTaxCalc().build());
        shoppingCart.add(new ItemBuilder(1, new Product("bottle of perfume",new BigDecimal("18.99"))).addSalesTaxCalc().build());
        shoppingCart.add(new ItemBuilder(1, new Product("packet of headache pills",new BigDecimal("9.75"))).build());
        shoppingCart.add(new ItemBuilder(1, new Product("box of imported chocolates",new BigDecimal("11.25"))).addImportTaxCalc().build());
        shoppingCart.add(new ItemBuilder(1, new Product("box of imported chocolates",new BigDecimal("11.25"))).addImportTaxCalc().build());

        Assert.assertEquals(new BigDecimal("7.30"), shoppingCart.getTotalTax());
        Assert.assertEquals(new BigDecimal("86.53"), shoppingCart.getTotalPrice());
    }
}
