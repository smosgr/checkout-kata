package gr.smos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Checkout {

    List<SKU> items = new ArrayList<>();

    private String pricingRules;


    Checkout() {
    }

    public void applyPricingRules(String pricingRules) {
    }

    public void scan(SKU item) {

        items.add(item);

    }

    public int calculateTotal() {

        int total = items.get(0).getPrice();

        return total;
    }

}
