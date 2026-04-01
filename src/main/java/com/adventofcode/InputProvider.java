package com.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputProvider {

    public String inputAsString(final File file) {
        try {
            return Files.readString(file.toPath()).trim();
        } catch (IOException exception) {
            throw new RuntimeException("File not found: " + file.getAbsolutePath(), exception);
        }
    }

    public List<Character> inputAsListOfCharacters(final File file) {
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

    public List<List<Integer>> inputAsListOfListsOfDimensions(final File file) {
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

    public List<String> inputAsListOfStrings(final File file) {
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException exception) {
            throw new RuntimeException("File not found: " + file.getAbsolutePath(), exception);
        }
    }

    public List<Integer> inputAsListOfIntegers(final File file) {
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
