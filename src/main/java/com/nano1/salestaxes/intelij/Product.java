package com.nano1.salestaxes.intelij;


import java.math.BigDecimal;

/**
 * Created by nano1 on 4/6/2016.
 */
public class Product {

    private String productName;
    private BigDecimal productPrice;

    public Product(String productName, BigDecimal productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Product(String productName, String productPrice) throws NumberFormatException {
        this(productName, new BigDecimal(productPrice));
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

}
