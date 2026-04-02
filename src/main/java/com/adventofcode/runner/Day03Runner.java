package com.adventofcode.runner;

import com.adventofcode.InputProvider;
import com.adventofcode.day03.Day03;

import java.nio.file.Path;
import java.util.function.Consumer;

public class Day03Runner implements Consumer<InputProvider> {

    @Override
    public void accept(final InputProvider provider) {
        final var filepath = Path.of("src/main/resources/inputs/day03.txt");
        final var input = provider.inputAsString(filepath);
        final var day = new Day03();
        System.out.println("Day 3, part I result: " + day.deliver(input, 1));
        System.out.println("Day 3, part II result: " + day.deliver(input, 2));
    }

}
