package com.adventofcode.runner;

import com.adventofcode.InputProvider;
import com.adventofcode.day02.Day02;

import java.nio.file.Path;
import java.util.function.Consumer;

public class Day02Runner implements Consumer<InputProvider> {

    @Override
    public void accept(final InputProvider provider) {
        final var filepath = Path.of("src/main/resources/inputs/day02.txt");
        final var input = provider.inputAsListOfListsOfDimensions(filepath);
        final var day = new Day02();
        System.out.println("Day 2, part I result: " + day.getTotalSquareFeet(input));
        System.out.println("Day 2, part II result: " + day.getTotalLength(input));
    }

}
