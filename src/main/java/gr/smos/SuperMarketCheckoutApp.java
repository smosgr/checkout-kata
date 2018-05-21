package gr.smos;

import java.util.ArrayList;
import java.util.List;

public class SuperMarketCheckoutApp {

    public static void main(String[] args) {

        List<SKU> scannedItems = new ArrayList<>();
        Checkout checkout = new Checkout();
        OutcomePrinter outcomePrinter = new OutcomePrinter();

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
        outcomePrinter.printFinalTotal(finalTotal, scannedItems);

    }
}
