package com.nano1.salestaxes.intelij;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by nano1 on 4/6/2016.
 */
public class SimpleTaxCalcTest {

    @Test
    public void testCalculate() throws Exception {
        SimpleTaxCalc simpleTaxCalc = new SimpleTaxCalc("0.10");

        assertEquals(new BigDecimal("1.00"),simpleTaxCalc.calculateTax(new BigDecimal("10.00")));
    }
}
