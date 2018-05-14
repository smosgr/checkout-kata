package gr.smos;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class SuperMarketCheckoutAppTest {

    @Test
    public void testHi() {
        SuperMarketCheckoutApp checkoutApp = new SuperMarketCheckoutApp();
        assertEquals("Hi", checkoutApp.testTest());
    }
}
