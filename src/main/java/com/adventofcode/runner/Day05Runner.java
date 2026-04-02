package com.adventofcode.runner;

import com.adventofcode.InputProvider;
import com.adventofcode.day05.CheckingMethod;
import com.adventofcode.day05.Day05;

import java.nio.file.Path;
import java.util.function.Consumer;

public class Day05Runner implements Consumer<InputProvider> {

    @Override
    public void accept(final InputProvider provider) {
        final var filepath = Path.of("src/main/resources/inputs/day05.txt");
        final var input = provider.inputAsListOfStrings(filepath);
        final var day = new Day05();
        System.out.println("Day 5, part I result: " + day.howManyStringsAreNice(input, CheckingMethod.STANDARD));
        System.out.println("Day 5, part II result: " + day.howManyStringsAreNice(input, CheckingMethod.BETTER));
    }

}
