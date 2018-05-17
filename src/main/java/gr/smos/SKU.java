package gr.smos;

//SKU: Stock Keeping Unit

public class SKU {
    private String name;

    private int price;

    SKU(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
