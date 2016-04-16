import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nano1 on 4/6/2016.
 */
public class ShoppingCart {

    private final List<Product> products = new ArrayList<>();

    public void add(Product product){
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal total = BigDecimal.ZERO;
        for (Product product : products){
            total = total.add(product.getSellingPrice());
        }
        return total;
    }

    public BigDecimal getTotalTax() {
        BigDecimal total = BigDecimal.ZERO;
        for (Product product : products){
            total = total.add(product.calculateTax());
        }
        return total;
    }

    public int size(){
        return products.size();
    }
}
