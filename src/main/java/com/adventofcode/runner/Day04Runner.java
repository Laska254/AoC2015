package com.adventofcode.runner;

import com.adventofcode.InputProvider;
import com.adventofcode.day04.Day04;

import java.nio.file.Path;
import java.util.function.Consumer;

public class Day04Runner implements Consumer<InputProvider> {

    @Override
    public void accept(final InputProvider provider) {
        final var filepath = Path.of("src/main/resources/inputs/day04.txt");
        final var secretKey = provider.inputAsString(filepath);
        final var day = new Day04();
        System.out.println("Day 4, part I result: " + day.findLowestPossibleNumber(secretKey, "00000"));
        System.out.println("Day 4, part II result: " + day.findLowestPossibleNumber(secretKey, "000000"));
    }

}
