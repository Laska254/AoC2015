package com.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputProvider {

    private InputProvider() {
    }

    public static String inputAsString(File file) {
        try {
            return Files.readString(file.toPath()).trim();
        } catch (IOException exception) {
            throw new RuntimeException("File not found: " + file.getAbsolutePath(), exception);
        }
    }

    public static List<Character> inputAsListOfCharacters(File file) {
        try {
            Scanner scanner = new Scanner(file);
            return scanner.next()
                    .chars()
                    .mapToObj(c -> (char) c)
                    .toList();
        } catch (FileNotFoundException exception) {
            throw new RuntimeException("File not found: " + file.getAbsolutePath(), exception);
        }
    }

    public static List<List<Integer>> inputAsListOfListsOfDimensions(File file) {
        try {
            Scanner scanner = new Scanner(file);
            return scanner.tokens()
                    .map(line -> Arrays.stream(line.split("x"))
                            .map(Integer::parseInt)
                            .toList())
                    .toList();
        } catch (FileNotFoundException exception) {
            throw new RuntimeException("File not found: " + file.getAbsolutePath(), exception);
        }
    }

    public static List<String> inputAsListOfStrings(File file) {
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException exception) {
            throw new RuntimeException("File not found: " + file.getAbsolutePath(), exception);
        }
    }

    public static List<Integer> inputAsListOfIntegers(File file) {
        try {
            return Files.readAllLines(file.toPath())
                    .stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (IOException exception) {
            throw new RuntimeException("File not found: " + file.getAbsolutePath(), exception);
        }
    }

}
