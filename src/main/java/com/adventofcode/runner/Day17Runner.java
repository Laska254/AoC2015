package com.adventofcode.runner;

import com.adventofcode.InputProvider;
import com.adventofcode.day17.Day17;

import java.io.File;
import java.util.function.Consumer;

public class Day17Runner implements Consumer<InputProvider> {

    @Override
    public void accept(final InputProvider provider) {
        final var file = new File("src/main/resources/inputs/day17.txt");
        final var input = provider.inputAsListOfIntegers(file);
        final var day = new Day17(input, 150);
        day.run();
        System.out.println("Day 17, part I & II results: " + day);
    }

}
