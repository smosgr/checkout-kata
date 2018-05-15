package gr.smos;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SuperMarketCheckoutAppTest {

    @Test
    public void oneA() {

        //given
        Checkout checkout = new Checkout();
        SKU item = new SKU("A", 1000);


        //when
        checkout.scan(item);

        //then
        assertEquals(1000, checkout.calculateTotal());
    }

}
