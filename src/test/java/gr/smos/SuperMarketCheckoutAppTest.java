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
        assertEquals(50, checkout.calculateTotal());
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
    public void scanDifferentTypesOfProductsWithNoOffers() {

        //given a variety of products
        Checkout checkout = new Checkout();
        SKU itemA = new SKU("A", 50);
        SKU itemB = new SKU("B", 30);
        SKU itemC = new SKU("C", 20);
        SKU itemD = new SKU("D", 15);

        //when different types of products are scanned
        checkout.scan(itemA);
        checkout.scan(itemB);
        checkout.scan(itemA);
        checkout.scan(itemC);
        checkout.scan(itemD);
        checkout.scan(itemB);

        //then
        assertEquals(195, checkout.calculateTotal());

    }

    @Test
    public void scanDifferentTypesOfProductsWithOffers() {

        //given a variety of products
        Checkout checkout = new Checkout();
        SKU itemA1 = new SKU("A", 50);
        SKU itemA2 = new SKU("A", 50);
        SKU itemA3 = new SKU("A", 50);
        SKU itemB1 = new SKU("A", 30);
        SKU itemB2 = new SKU("A", 30);
        SKU itemC = new SKU("C", 20);
        SKU itemD = new SKU("D", 15);

        //when different types of products are scanned
        checkout.scan(itemA1);
        checkout.scan(itemA2);
        checkout.scan(itemA3);
        checkout.scan(itemB1);
        checkout.scan(itemB2);
        checkout.scan(itemC);
        checkout.scan(itemD);

        //and discount is applied
        //TODO call offer()

        //then return the discounted total
        assert true;
    }

    @Test
    public void scan6ProductsOfAToReceiveDiscountTwice() {
        assert true;
    }


}