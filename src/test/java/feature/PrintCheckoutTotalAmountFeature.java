package feature;

import gr.smos.Checkout;
import gr.smos.OutcomePrinter;
import gr.smos.SKU;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PrintCheckoutTotalAmountFeature {

    private Checkout checkout;
    private OutcomePrinter outcomePrinter;


    @Before
    public void initialise() {
        checkout = new Checkout();
        outcomePrinter = new OutcomePrinter();

    }

    @Test
    public void printTotalPriceWithDiscountsApplied() {
        /*
        Acceptance criteria for a basic checkout user journey:

        As a customer I want to buy a NUMBER OF ITEMS
        and get as outcome the total price of the scanned items with the current offers applied.

        Given I have 3 Products of type A, 3 of type B, 2 of type C and 1 of type D
        When I scan them at the supermarket checkout
        Then the relevant offers are applied
        And the final price is displayed as output.

        Example based on the above acceptance criteria:
        ----------------------------------------------------------
        Items scanned: A, C, D, B, B, B, A, C, A
        Offers applied for: A (3 for 130), B (2 for 45)
        Final price: 260

         */

        List<SKU> scannedItems = new ArrayList<>();


        SKU itemA1 = new SKU("A", 50);
        SKU itemC1 = new SKU("C", 20);
        SKU itemD1 = new SKU("D", 15);
        SKU itemB1 = new SKU("B", 30);
        SKU itemB2 = new SKU("B", 30);
        SKU itemB3 = new SKU("B", 30);
        SKU itemA2 = new SKU("A", 50);
        SKU itemC2 = new SKU("C", 20);
        SKU itemA3 = new SKU("A", 50);

        scannedItems.add(itemA1);
        scannedItems.add(itemC1);
        scannedItems.add(itemD1);
        scannedItems.add(itemB1);
        scannedItems.add(itemB2);
        scannedItems.add(itemB3);
        scannedItems.add(itemA2);
        scannedItems.add(itemC2);
        scannedItems.add(itemA3);

        int finalTotal = checkout.calculateTotal(scannedItems, false);

        String printFinalTotal = outcomePrinter.printFinalTotal(finalTotal, scannedItems);

        String expectedOutput = "Items scanned: A, C, D, B, B, B, A, C, A, " + "\n" +
                //TODO: apply offers
                "Offers applied for: A (3 for 130), B (2 for 45)" + "\n" +
                "Final price: 295";

        assertEquals(expectedOutput, printFinalTotal);

    }
}
