package taxes;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by nano1 on 4/6/2016.
 */
public abstract class AbstractTaxCalc implements TaxCalculator {

    public abstract BigDecimal calculate(BigDecimal value);

    @Override
    public BigDecimal calculateTax(BigDecimal value) {
        BigDecimal tax = calculate(value);
        return round(tax);
    }

    private BigDecimal round(BigDecimal value){
        value = value.multiply(new BigDecimal("20"))
                .setScale(0, BigDecimal.ROUND_UP)
                .setScale(2);
        value = value.divide(new BigDecimal("20"), RoundingMode.UP);
        return value;
    }
}
