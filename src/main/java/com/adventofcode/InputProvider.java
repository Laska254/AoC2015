package com.adventofcode;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class InputProvider {

    public String inputAsString(final Path path) {
        try {
            return Files.readString(path).trim();
        } catch (IOException exception) {
            throw new UncheckedIOException("Failed to read file: " + path, exception);
        }
    }

    public List<Character> inputAsListOfCharacters(final Path path) {
        return inputAsString(path)
                .chars()
                .mapToObj(c -> (char) c)
                .toList();
    }

    public List<List<Integer>> inputAsListOfListsOfDimensions(final Path path) {
        try {
            return Files.lines(path)
                    .map(line -> Arrays.stream(line.split("x"))
                            .map(Integer::parseInt)
                            .toList())
                    .toList();
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to read file: " + path, e);
        }
    }

    public List<String> inputAsListOfStrings(final Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to read file: " + path, e);
        }
    }

    public List<Integer> inputAsListOfIntegers(final Path path) {
        return inputAsListOfStrings(path)
                .stream()
                .map(Integer::parseInt)
                .toList();
    }

}
