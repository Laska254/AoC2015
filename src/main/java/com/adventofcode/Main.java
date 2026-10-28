package com.adventofcode;

import java.nio.file.ProviderNotFoundException;
import java.util.Scanner;
import java.util.function.Supplier;

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
                final var solution = Days.solution(choice);
                if (solution.isPresent()) {
                    run(choice, solution.get());
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

    private static void run(final int day, final Solution solution) {
        Days.input(day).ifPresentOrElse(
                input -> {
                    System.out.println(line(day, 1, () -> solution.partOne(input)));
                    System.out.println(line(day, 2, () -> solution.partTwo(input)));
                },
                () -> System.out.println("put your input at src/main/resources/" + Days.inputPath(day))
        );
    }

    static String line(final int day, final int part, final Supplier<Object> answer) {
        final var prefix = "Day " + day + " · part " + part + ": ";
        try {
            return prefix + answer.get();
        } catch (final UnsupportedOperationException exception) {
            return prefix + "not solved yet";
        }
    }

}
