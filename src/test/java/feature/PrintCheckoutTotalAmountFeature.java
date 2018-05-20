package feature;

import gr.smos.Checkout;
import gr.smos.Offer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class PrintCheckoutTotalAmountFeature {

    private Checkout checkout;

    @Before
    public void initialise() {
        checkout = new Checkout();

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

        Offer offer = Mockito.mock(Offer.class);
        offer.applyPricingRules("TEST-RULES");

        String finalTotal = checkout.printFinalTotal();

        String expectedFinalTotal = "Items scanned: [A, C, D, B, B, B, A, C, A]" + "\n" +
                "Offers applied for: A (3 for 130), B (2 for 45)" + "\n" +
                "Final price: 260";

        assertEquals(expectedFinalTotal, finalTotal);

    }
}
