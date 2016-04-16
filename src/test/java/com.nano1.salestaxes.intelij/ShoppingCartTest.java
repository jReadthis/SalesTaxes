package com.nano1.salestaxes.intelij;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by nano1 on 4/7/2016.
 */
public class ShoppingCartTest {

    ShoppingCart shoppingCart = new ShoppingCart();
    List<TaxCalculator> taxCalculators = new ArrayList<>();

    Product product = new Product("book",new BigDecimal("12.99"));
    Product product2 = new Product("table", new BigDecimal("155.99"));
    Product product3 = new Product("desk", new BigDecimal("120.99"));

    @Test
    public void testAdd() throws Exception {
        shoppingCart.add(new ItemBuilder(1, product).build());

        assertEquals(1,shoppingCart.size());
    }

    @Test
    public void testAdd2() throws Exception {
        shoppingCart.add(new ItemBuilder(1, product).build());
        shoppingCart.add(new ItemBuilder(1, product).build());
        shoppingCart.add(new ItemBuilder(1, product).build());

        assertEquals(3, shoppingCart.getProducts().get(0).getQuantity() );
    }

    @Test
    public void testGetProducts() throws Exception {
        shoppingCart.add(new ItemBuilder(1, product).build());

        assertEquals("[book: 12.99]", shoppingCart.getProducts().toString());
    }

    @Test
    public void testGetTotalPrice() throws Exception {
        shoppingCart.add(new ItemBuilder(1, product).build());

        assertEquals(new BigDecimal("12.99"),shoppingCart.getTotalPrice());
    }

    @Test
    public void testGetTotalTax() throws Exception {
        shoppingCart.add(new ItemBuilder(1, product).build());
        shoppingCart.add(new ItemBuilder(1, product).build());

        assertEquals(new BigDecimal("0"), shoppingCart.getTotalTax());
    }

    @Test
    public void testSize() throws Exception {
        shoppingCart.add(new ItemBuilder(1, product).build());
        shoppingCart.add(new ItemBuilder(1, product2).build());
        shoppingCart.add(new ItemBuilder(1, product3).build());

        assertEquals(3,shoppingCart.size());
    }
}