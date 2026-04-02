package com.adventofcode.runner;

import com.adventofcode.InputProvider;
import com.adventofcode.day19.Day19;

import java.nio.file.Path;
import java.util.function.Consumer;

public class Day19Runner implements Consumer<InputProvider> {

    @Override
    public void accept(final InputProvider provider) {
        final var filepath = Path.of("src/main/resources/inputs/day19.txt");
        final var input = provider.inputAsListOfStrings(filepath);
        final var day = new Day19(input);
        System.out.println("Day 19, part I results: " + day.checkAndReplace());
    }

}
