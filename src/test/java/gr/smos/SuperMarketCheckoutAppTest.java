package gr.smos;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class SuperMarketCheckoutAppTest {

    @Test
    public void scanOneItemOfProductA() {

        //given
        Checkout checkout = new Checkout();
        List<SKU> scannedItems = new ArrayList<>();
        SKU item = new SKU("A", 50);

        //when
        scannedItems.add(item);

        //then
        assertEquals(50, checkout.calculateTotal(scannedItems, false));
    }


    @Test
    public void scanTwoItemsOfProductA() {

        //given
        Checkout checkout = new Checkout();
        List<SKU> scannedItems = new ArrayList<>();

        SKU item1, item2;
        item1 = new SKU("A", 50);
        item2 = new SKU("A", 50);

        //when
        scannedItems.add(item1);
        scannedItems.add(item2);

        //then
        assertEquals(100, checkout.calculateTotal(scannedItems, false));
    }


    @Test
    public void scanXItemsOfProductA() {

        //given we have 10 items of product 'A'
        Checkout checkout = new Checkout();
        List<SKU> scannedItems = new ArrayList<>();
        SKU item[] = new SKU[10];

        for (int i = 0; i < 10; i++) {
            item[i] = new SKU("A", 50);
        }

        //when we scan all 'A' products
        for (int j = 0; j < item.length; j++) {
            scannedItems.add(item[j]);
        }

        //then
        assertEquals(500, checkout.calculateTotal(scannedItems, false));
    }

    @Test
    public void scanDifferentTypesOfProductsWithNoOffers() {

        //given a variety of products
        Checkout checkout = new Checkout();
        List<SKU> scannedItems = new ArrayList<>();
        SKU itemA = new SKU("A", 50);
        SKU itemB = new SKU("B", 30);
        SKU itemC = new SKU("C", 20);
        SKU itemD = new SKU("D", 15);


        //when different types of products are scanned
        scannedItems.add(itemA);
        scannedItems.add(itemB);
        scannedItems.add(itemA);
        scannedItems.add(itemC);
        scannedItems.add(itemD);
        scannedItems.add(itemB);

        //then
        assertEquals(195, checkout.calculateTotal(scannedItems, false));
    }

    @Ignore
    @Test
    public void scanDifferentTypesOfProductsWithOffers() {

        //given a variety of products
        Checkout checkout = new Checkout();

        List<SKU> scannedItems = new ArrayList<>();
        SKU itemA1 = new SKU("A", 50);
        SKU itemA2 = new SKU("A", 50);
        SKU itemA3 = new SKU("A", 50);
        SKU itemB1 = new SKU("B", 30);
        SKU itemB2 = new SKU("B", 30);
        SKU itemC = new SKU("C", 20);
        SKU itemD = new SKU("D", 15);

        //when different types of products are scanned
        scannedItems.add(itemA1);
        scannedItems.add(itemA2);
        scannedItems.add(itemA3);
        scannedItems.add(itemB1);
        scannedItems.add(itemB2);
        scannedItems.add(itemC);
        scannedItems.add(itemD);


        //then return the discounted total
        assertEquals(210, checkout.calculateTotal(scannedItems, true));
    }

}