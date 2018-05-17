package gr.smos;

public class SuperMarketCheckoutApp {

    public static void main(String[] args) {
        init();
    }

    public static void init() {

        ConsoleApp consoleApp = new ConsoleApp();
        consoleApp.setupConsole();


        while (consoleApp.readFromConsole().equals("Q")) {
            consoleApp.readFromConsole();
        }

        System.exit(1);
    }
}
