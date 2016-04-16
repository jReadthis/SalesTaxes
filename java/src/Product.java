import taxes.TaxCalculator;

import java.math.BigDecimal;

/**
 * Created by nano1 on 4/6/2016.
 */
public class Product {

    private String productName;
    private BigDecimal productPrice;
    private TaxCalculator taxCalculator;

    public Product(String productName, BigDecimal productPrice, TaxCalculator taxCalculator) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.taxCalculator = taxCalculator;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal calculateTax(){
        return taxCalculator.calculateTax(productPrice);
    }

    public BigDecimal getSellingPrice(){
        return productPrice.add(calculateTax());
    }
}
