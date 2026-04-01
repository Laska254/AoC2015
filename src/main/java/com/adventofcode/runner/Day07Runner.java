package com.adventofcode.runner;

import com.adventofcode.InputProvider;
import com.adventofcode.day07.Day07;

import java.io.File;
import java.util.function.Consumer;

public class Day07Runner implements Consumer<InputProvider> {

    @Override
    public void accept(final InputProvider provider) {
        final var file = new File("src/main/resources/inputs/day07.txt");
        final var input = provider.inputAsListOfStrings(file);
        final var day = new Day07();
        System.out.println("Day 7, part I result: " + day.run(input));
        System.out.println("Day 7, part II result: " + day.runPart2(input));
    }

}
