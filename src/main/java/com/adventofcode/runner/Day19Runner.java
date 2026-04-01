package com.adventofcode.runner;

import com.adventofcode.InputProvider;
import com.adventofcode.day19.Day19;

import java.io.File;
import java.util.function.Consumer;

public class Day19Runner implements Consumer<InputProvider> {

    @Override
    public void accept(final InputProvider provider) {
        final var file = new File("src/main/resources/inputs/day19.txt");
        final var input = provider.inputAsListOfStrings(file);
        final var day = new Day19(input);
        System.out.println("Day 19, part I results: " + day.checkAndReplace());
    }

}
