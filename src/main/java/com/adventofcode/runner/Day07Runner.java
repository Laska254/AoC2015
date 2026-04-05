package com.adventofcode.runner;

import com.adventofcode.InputProvider;
import com.adventofcode.day07.Day07;

import java.nio.file.Path;
import java.util.function.Consumer;

public class Day07Runner implements Consumer<InputProvider> {

    @Override
    public void accept(final InputProvider provider) {
        final var filepath = Path.of("src/main/resources/inputs/day07.txt");
        final var input = provider.inputAsListOfStrings(filepath);
        final var day = new Day07();
        System.out.println("Day 7, part I result: " + day.partI(input));
        System.out.println("Day 7, part II result: " + day.partII(input));
    }

}
