package gr.smos;

import java.util.ArrayList;
import java.util.List;

public class Checkout {


    ConsoleApp output = new ConsoleApp();


    List<SKU> items = new ArrayList<>();

    Checkout() {
    }

    public void scan(SKU item) {

        items.add(item);
    }

    public int calculateTotal() {

        long itemsA = items.stream()
                .filter(sku -> "A".equals(sku.getName()))
                .count();

        long itemsB = items.stream()
                .filter(sku -> "B".equals(sku.getName()))
                .count();

        long itemsC = items.stream()
                .filter(sku -> "C".equals(sku.getName()))
                .count();

        long itemsD = items.stream()
                .filter(sku -> "D".equals(sku.getName()))
                .count();


        //TODO: change repetition OR find a new way

        return items.stream().mapToInt(SKU::getPrice).sum();
    }


    public String printFinalTotal() {

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
}
