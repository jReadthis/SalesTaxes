package tests;

import org.junit.Test;
import taxes.AbstractTaxCalc;
import taxes.SimpleTaxCalc;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by nano1 on 4/6/2016.
 */
public class AbstractTaxCalcTest {

    AbstractTaxCalc abstractTaxCalc;
    AbstractTaxCalc abstractTaxCalc2;
    BigDecimal price;
    BigDecimal price2;

    @Test
    public void testCalculate() throws Exception {
        price = new BigDecimal("14.99");
        price2 = new BigDecimal("10.00");

        abstractTaxCalc = new SimpleTaxCalc("0.10");
        BigDecimal totalPrice = abstractTaxCalc.calculate(price);

        abstractTaxCalc2 = new SimpleTaxCalc("0.05");
        BigDecimal totalPrice2 = abstractTaxCalc2.calculate(price2);

        assertEquals(new BigDecimal("1.4990"), totalPrice);
        assertEquals(new BigDecimal("0.5000"), totalPrice2);
    }

    @Test
    public void testCalculateTax() throws Exception {

        price = new BigDecimal("14.99");
        price2 = new BigDecimal("10.00");

        abstractTaxCalc = new SimpleTaxCalc("0.10");
        BigDecimal totalPrice = abstractTaxCalc.calculateTax(price);
        abstractTaxCalc2 = new SimpleTaxCalc("0.05");
        BigDecimal toalPrice2 = abstractTaxCalc2.calculateTax(price2);

        assertEquals(new BigDecimal("1.50"), totalPrice);
        assertEquals(new BigDecimal("0.50"), toalPrice2);

    }
}