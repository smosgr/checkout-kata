package gr.smos;

import java.util.ArrayList;
import java.util.List;

public class Checkout {

    public Checkout() {
    }

    public int calculateTotal(List<SKU> items, boolean withOffer) {
        if (withOffer) {
            return checkForCurrentOffers(items);
        } else
            return items.stream().mapToInt(SKU::getPrice).sum();
    }

    public String printFinalTotal() {
        //TODO: content to be removed - will only be able to print the outcome. Possibly in a Printer class.

        List<String> scannedItems = new ArrayList<>();
        scannedItems.add("A");
        scannedItems.add("C");
        scannedItems.add("D");
        scannedItems.add("B");
        scannedItems.add("B");
        scannedItems.add("B");
        scannedItems.add("A");
        scannedItems.add("C");
        scannedItems.add("A");

        String finalTotal = "Items scanned: " + scannedItems + "\n"
                + "Offers applied for: A (3 for 130), B (2 for 45)" + "\n"
                + "Final price: 260";

        return finalTotal;
    }

    private int checkForCurrentOffers(List<SKU> items) {

        //TODO apply offers for the basket items

        int total = 0;

        long itemsA = items.stream()
                .filter(sku -> "A".equals(sku.getName()))
                .count();

        long itemsB = items.stream()
                .filter(sku -> "B".equals(sku.getName()))
                .count();

        return total;
    }

}
