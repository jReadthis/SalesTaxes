package com.nano1.salestaxes.intelij;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nano1 on 4/6/2016.
 */
public class ItemBuilder {
    private String name;
    private BigDecimal price;
    private int quantity;

    private List<TaxCalculator> taxCalculators = new ArrayList<>();

    public ItemBuilder(int quantity, Product product) {
        this.name = product.getProductName();
        this.price = product.getProductPrice();
        this.quantity = quantity;
    }

    public ItemBuilder addTaxCalc(TaxCalculator taxCalculator){
        this.taxCalculators.add(taxCalculator);
        return this;
    }

    public ItemBuilder addImportTaxCalc(){
        return addTaxCalc(new ImportTaxCalc());
    }

    public ItemBuilder addSalesTaxCalc(){
        return addTaxCalc(new SalesTaxCalc());
    }

    public ShoppingCartItem build(){
        return new ShoppingCartItem(name, price, quantity, new GroupedTaxCalc(taxCalculators));
    }
}
