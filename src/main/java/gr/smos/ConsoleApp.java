package gr.smos;

import java.util.Scanner;

public class ConsoleApp {

    ConsoleApp() {
    }

    public void setupConsole() {

        System.out.println(" Please scan your items for checkout. Type in the type of product and then press 'Enter'. " +
                "Example: 'A' <ENTER> 'A' <ENTER> 'D' <ENTER>. " +
                "Type ('Q' to exit)\n ");

    }

    public String readFromConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    //TODO input validator. The application assumes that it will be receiving product names only e.g. A, B, C, D.
}