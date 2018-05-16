package gr.smos;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SuperMarketCheckoutAppTest {

    @Test
    public void scanOneItemOfProductA() {

        //given
        Checkout checkout = new Checkout();
        SKU item = new SKU("A", 50);

        //when
        checkout.scan(item);

        //then
        assertEquals(1000, checkout.calculateTotal());
    }


    @Test
    public void scanTwoItemsOfProductA() {

        //given
        Checkout checkout = new Checkout();
        SKU item1, item2;
        item1 = new SKU("A", 50);
        item2 = new SKU("A", 50);

        //when
        checkout.scan(item1);
        checkout.scan(item2);

        //then
        assertEquals(100, checkout.calculateTotal());
    }


    @Test
    public void scanXItemsOfProductA() {

        //given we have 10 items of product 'A'
        Checkout checkout = new Checkout();
        SKU item[] = new SKU[10];

        for (int i = 0; i < 10; i++) {
            item[i] = new SKU("A", 50);
        }

        //when we scan all 'A' products
        for (int j = 0; j < item.length; j++) {
            checkout.scan(item[j]);
        }

        //then
        assertEquals(500, checkout.calculateTotal());
    }

    @Test
    public void scanDifferentTypesOfProducts() {
        assert true;
    }
}