package com.adventofcode;

import java.nio.file.ProviderNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final var inputProvider = new InputProvider();
        try (final var scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Please choose day (1-25) to see results or enter 0 to exit.");
                System.out.print("Your choice: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input.");
                    continue;
                }
                final var choice = scanner.nextInt();
                if (choice == 0) {
                    return;
                }
                if (choice < 0 || choice > 25) {
                    System.out.println("Invalid input. Please select day (1-25)");
                    continue;
                }
                try {
                    final var runner = Calendar.getRunner(choice);
                    runner.accept(inputProvider);
                } catch (final ProviderNotFoundException exception) {
                    System.out.println("Day " + choice + " not implemented yet.");
                }
            }
        }
    }

}
