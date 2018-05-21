package gr.smos;

import java.util.Collections;
import java.util.List;

public class Checkout {

    public Checkout() {
    }

    public int calculateTotal(List<SKU> items, boolean withOffer) {
        if (withOffer) {
            return checkForCurrentOffers(items);

        } else {
            return items.stream().mapToInt(SKU::getPrice).sum();
        }
    }


    private int checkForCurrentOffers(List<SKU> items) {

        //TODO apply offers for the basket items

        int total = 0;

        long itemsA = items.stream()
                .filter(sku -> "A".equals(sku.getName()))
                .count();

        int index = Collections.frequency(items, "A");


        long itemsB = items.stream()
                .filter(sku -> "B".equals(sku.getName()))
                .count();

        long itemsC = items.stream()
                .filter(sku -> "C".equals(sku.getName()))
                .count();

        long itemsD = items.stream()
                .filter(sku -> "D".equals(sku.getName()))
                .count();

        return 1;
    }

}
