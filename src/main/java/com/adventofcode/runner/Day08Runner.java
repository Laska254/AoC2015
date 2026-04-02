package com.adventofcode.runner;

import com.adventofcode.InputProvider;
import com.adventofcode.day08.Day08;

import java.nio.file.Path;
import java.util.function.Consumer;

public class Day08Runner implements Consumer<InputProvider> {

    @Override
    public void accept(final InputProvider provider) {
        final var filepath = Path.of("src/main/resources/inputs/day08.txt");
        final var input = provider.inputAsListOfStrings(filepath);
        final var day = new Day08();
        System.out.println("Day 8, part I result: " + day.calculate(input));
        System.out.println("Day 8, part II result: " + day.calculateEncoded(input));
    }

}
