import taxes.GroupedTaxCalc;
import taxes.ImportTaxCalc;
import taxes.SalesTaxCalc;
import taxes.TaxCalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nano1 on 4/6/2016.
 */
public class ProductBuilder {
    private String name;
    private BigDecimal price;
    private List<TaxCalculator> taxCalculators = new ArrayList<>();

    public ProductBuilder(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public ProductBuilder addTaxCalc(TaxCalculator taxCalculator){
        this.taxCalculators.add(taxCalculator);
        return this;
    }

    public ProductBuilder addImportTaxCalc(){
        return addTaxCalc(new ImportTaxCalc());
    }

    public ProductBuilder addSalesTaxCalc(){
        return addTaxCalc(new SalesTaxCalc());
    }

    public Product build(){
        return new Product(name,price,new GroupedTaxCalc(taxCalculators));
    }
}
