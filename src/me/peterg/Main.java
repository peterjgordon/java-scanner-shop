package me.peterg;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // buy 3 things
        // 1-shed 2-handbag 3-tractor
        //
        // ask how many people they're ordering for (no more than 5)
        // prompt to re-enter input if > 5
        // address of each person
        // thank you for ordering x, print addresses for each person

        Scanner scanner = new Scanner(System.in);
        String[] items = {"Shed", "Handbag", "Tractor"};

        System.out.println(" Welcome to TheDump Ltd\n");
        System.out.println("====== Catalogue ======");
        for (int i = 0; i < items.length; i++) System.out.println((i + 1) + ". " + items[i]);
        System.out.println("=======================\n");
        System.out.print("Select an item no: ");
        int itemNo = obtainInt(scanner)-1; // -1 to account for zero-based index

        System.out.println("\nHow many people are you ordering for?");
        System.out.println("There is a maximum of 5 per order.");
        int quantity = Integer.MAX_VALUE;
        while (quantity < 1 || quantity > 5) {
            quantity = obtainInt(scanner);
        }

        String[] addresses = new String[quantity];
        System.out.println("\nPlease provide the delivery address of each person.");
        for (int i = 0; i < quantity; i++) {
            System.out.print((i + 1) + ". ");
            addresses[i] = scanner.nextLine();
        }

        System.out.println("\nThank you for ordering a " + items[itemNo] + "!\n");
        System.out.println("====== Delivery Details ======");
        System.out.println("Item Name:        " + items[itemNo]);
        System.out.println("Quantity Ordered: " + quantity);
        for (String address : addresses) {
            System.out.println(address);
        }
        System.out.println("==============================");

    }

    private static int obtainInt(Scanner scanner) {
        // Prevent errors if non-int input is provided
        while (!scanner.hasNextInt()) if (scanner.hasNext()) scanner.nextLine();
        int input = scanner.nextInt();
        scanner.nextLine(); // absorb the "\n" following the int
        return input;
    }
}
