package com.adventofcode;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            final var scanner = new Scanner(System.in);
            System.out.println("Please choose day (1-25) to see results or enter 0 to exit.");
            System.out.print("Your choice: ");
            final var choice = scanner.nextInt();
            if (choice == 0) {
                return;
            }
            final var inputProvider = new InputProvider();
            final var runner = Calendar.getRunner(choice);
            if (runner != null) {
                runner.accept(inputProvider);
            } else {
                System.out.println("Invalid option, please use number between 1 and 25.");
            }
        }
    }

}
