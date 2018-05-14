package gr.smos;

public class SuperMarketCheckoutApp {

    public static void main(String[] args) {
        init();
    }

    public static void init() {

        String pricingRules = "test-pricing";

        Checkout co = new Checkout();
        co.setPricingRules(pricingRules);

    }

    public String testTest() {
        return "Hi";
    }
}
