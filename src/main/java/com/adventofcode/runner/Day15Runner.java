package com.adventofcode.runner;

import com.adventofcode.InputProvider;
import com.adventofcode.day15.Day15;

import java.nio.file.Path;
import java.util.function.Consumer;

public class Day15Runner implements Consumer<InputProvider> {

    @Override
    public void accept(final InputProvider provider) {
        final var filepath = Path.of("src/main/resources/inputs/day15.txt");
        final var input = provider.inputAsListOfStrings(filepath);
        final var day = new Day15(input);
        System.out.println(day.run());
    }

}
