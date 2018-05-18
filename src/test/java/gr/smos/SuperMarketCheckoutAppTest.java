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


    @Test
    public void testPrintingXProductsAtCheckout() {

        /*
        Acceptance criteria for a basic user journey:

        As a customer I want to buy A SET OF PRODUCTS
        and see the final price displayed in my screen.

        Given I have 3 Products of type A, 3 of type B, 2 of type C and 1 of type D
        When I scan them at the supermarket checkout
        Then the relevant offers are applied
        And the final price is displayed in my terminal.

        Example output
        ----------------------------------------------------------
        Items scanned: A, C, D, B, B, B, A, C, A
        Offers applied for: A (3 for 130), B (2 for 45)
        Final price: 260
         */

        Checkout checkout = new Checkout();

        String expectedFinalTotal = "Items scanned: A, C, D, B, B, B, A, C, A" + "\n" +
                "Offers applied for: A (3 for 130), B (2 for 45)" + "\n" +
                "Final price: 260";

        assertEquals(expectedFinalTotal, checkout.printFinalTotal());

    }

}