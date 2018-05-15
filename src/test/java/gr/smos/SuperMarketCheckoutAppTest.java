package gr.smos;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SuperMarketCheckoutAppTest {

    @Test
    public void oneA() {
        Checkout checkout = new Checkout();
        SKU item = new SKU();
        checkout.scan(item);

        assertEquals(123, checkout.calculateTotal());
    }

}
