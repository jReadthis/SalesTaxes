package taxes;

import java.math.BigDecimal;

/**
 * Created by nano1 on 4/6/2016.
 */
public interface TaxCalculator {
    BigDecimal calculateTax(BigDecimal value);
}
