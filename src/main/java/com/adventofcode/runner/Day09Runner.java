package com.adventofcode.runner;

import com.adventofcode.InputProvider;
import com.adventofcode.day09.Day09;
import com.adventofcode.day09.SearchType;

import java.nio.file.Path;
import java.util.function.Consumer;

public class Day09Runner implements Consumer<InputProvider> {

    @Override
    public void accept(final InputProvider provider) {
        final var filepath = Path.of("src/main/resources/inputs/day09.txt");
        final var input = provider.inputAsListOfStrings(filepath);
        final var day = new Day09();
        System.out.println("Day 9, part I result: " + day.getResultDistance(input, SearchType.SHORTEST));
        System.out.println(day.getResultRoute());
        System.out.println("Day 9, part II result: " + day.getResultDistance(input, SearchType.LONGEST));
        System.out.println(day.getResultRoute());
    }

}
