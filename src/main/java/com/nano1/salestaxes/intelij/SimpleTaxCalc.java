package com.nano1.salestaxes.intelij;

import java.math.BigDecimal;

/**
 * Created by nano1 on 4/6/2016.
 */
public class SimpleTaxCalc extends AbstractTaxCalc {

    private BigDecimal tax;

    public SimpleTaxCalc(BigDecimal tax){
        this.tax = tax;
    }

    public SimpleTaxCalc(String tax){
        this(new BigDecimal(tax));
    }

    @Override
    public BigDecimal calculate(BigDecimal value) {
        return value.multiply(tax);
    }
}

