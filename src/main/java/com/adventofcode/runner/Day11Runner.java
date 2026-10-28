package com.adventofcode.runner;

import com.adventofcode.InputProvider;
import com.adventofcode.day11.Day11;

import java.nio.file.Path;
import java.util.function.Consumer;

public class Day11Runner implements Consumer<InputProvider> {

    @Override
    public void accept(final InputProvider provider) {
        final var filepath = Path.of("src/main/resources/inputs/day11.txt");
        final var input = provider.inputAsString(filepath);
        final var day = new Day11();
        final var password = day.generateNewPassword(input);
        System.out.println("Day 11, part I result: " + password);
        System.out.println("Day 11, part II result: " + day.generateNewPassword(password));
    }

}
