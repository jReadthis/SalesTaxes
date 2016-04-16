package com.nano1.salestaxes.intelij;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by nano1 on 4/7/2016.
 */
public class GroupedTaxCalc implements TaxCalculator {

    private List<TaxCalculator> taxCalculators = new ArrayList<>();

    public GroupedTaxCalc(Collection<TaxCalculator> taxCalculators) {
        this.taxCalculators.addAll(taxCalculators);
    }

    @Override
    public BigDecimal calculateTax(BigDecimal value) {
        BigDecimal tax = BigDecimal.ZERO;
        for (TaxCalculator taxCalculator : taxCalculators) {
            tax = tax.add(taxCalculator.calculateTax(value));
        }
        return tax;
    }
}
