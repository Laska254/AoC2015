package com.adventofcode.runner;

import com.adventofcode.InputProvider;
import com.adventofcode.day10.Day10;

import java.nio.file.Path;
import java.util.function.Consumer;

public class Day10Runner implements Consumer<InputProvider> {

    @Override
    public void accept(final InputProvider provider) {
        final var filepath = Path.of("src/main/resources/inputs/day10.txt");
        final var input = provider.inputAsString(filepath);
        final var day = new Day10();
        System.out.println("Day 10, part I result: " + day.lengthAfterIterations(input, 40));
        System.out.println("Day 10, part II result: " + day.lengthAfterIterations(input, 50));
    }

}
