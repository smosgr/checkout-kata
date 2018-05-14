import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SuperMarketCheckoutAppTest {

    @Test
    public void testHi() {
        SuperMarketCheckoutApp checkoutApp = new SuperMarketCheckoutApp();
        String s = checkoutApp.init();

        assertEquals("Hi", s);
    }
}
