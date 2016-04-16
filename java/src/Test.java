/**
 * Created by nano1 on 4/7/2016.
 */
public class Test {

    @org.junit.Test
    public void Test1(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new ProductBuilder("Book","12.49").build());
    }
}
