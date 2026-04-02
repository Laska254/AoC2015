package com.adventofcode.runner;

import com.adventofcode.InputProvider;
import com.adventofcode.day01.Day01;

import java.nio.file.Path;
import java.util.function.Consumer;

public class Day01Runner implements Consumer<InputProvider> {

    @Override
    public void accept(final InputProvider provider) {
        final var filepath = Path.of("src/main/resources/inputs/day01.txt");
        final var input = provider.inputAsListOfCharacters(filepath);
        final var day = new Day01();
        System.out.println("Day 1, part I result: " + day.calculateFloor(input));
        System.out.println("Day 1, part II result: " + day.findPositionOfBasementEnter(input));
    }

}
