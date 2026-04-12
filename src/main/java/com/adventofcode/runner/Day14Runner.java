package com.adventofcode.runner;

import com.adventofcode.InputProvider;
import com.adventofcode.day14.Day14;

import java.nio.file.Path;
import java.util.function.Consumer;

public class Day14Runner implements Consumer<InputProvider> {

    @Override
    public void accept(final InputProvider provider) {
        final var filepath = Path.of("src/main/resources/inputs/day14.txt");
        final var input = provider.inputAsListOfStrings(filepath);
        final var day = new Day14(input);
        day.run();
        System.out.println("Day 14, part I result: " + day.getMaxDistance());
        System.out.println("Day 14, part II result: " + day.getMaxScore());
    }

}
