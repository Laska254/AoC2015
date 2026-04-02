package com.adventofcode.runner;

import com.adventofcode.InputProvider;
import com.adventofcode.day06.Day06;

import java.nio.file.Path;
import java.util.function.Consumer;

public class Day06Runner implements Consumer<InputProvider> {

    @Override
    public void accept(final InputProvider provider) {
        final var filepath = Path.of("src/main/resources/inputs/day06.txt");
        final var input = provider.inputAsListOfStrings(filepath);
        final var day = new Day06();
        day.run(input);
        System.out.println("Day 6, part I result: " + day.howManyLightsAreLit());
        System.out.println("Day 6, part II result: " + day.totalBrightness());
    }

}
