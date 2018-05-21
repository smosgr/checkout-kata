package gr.smos;

import java.util.List;

public class OutcomePrinter {

    public OutcomePrinter() {

    }

    public String printFinalTotal(int finalTotal, List<SKU> scannedItems) {

        String items = "";
        for (SKU s : scannedItems) {
            items += s.getName() + ", ";
        }

        return "Items scanned: " + items + "\n"
                + "Offers applied for: A (3 for 130), B (2 for 45)" + "\n"
                + "Final price: " + finalTotal;
    }


}
