package com.adventofcode.runner;

import com.adventofcode.InputProvider;
import com.adventofcode.day18.Day18;

import java.io.File;
import java.util.function.Consumer;

public class Day18Runner implements Consumer<InputProvider> {

    @Override
    public void accept(final InputProvider provider) {
        final var file = new File("src/main/resources/inputs/day18.txt");
        final var input = provider.inputAsListOfStrings(file);
        final var day = new Day18(input, 100);
        System.out.println("Day 18, part I results: " + day.solvePartI());
        System.out.println("Day 18, part II results: " + day.solvePartII());
    }
}
