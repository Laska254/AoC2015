package com.adventofcode.runner;

import com.adventofcode.InputProvider;
import com.adventofcode.day20.Day20;

import java.nio.file.Path;
import java.util.function.Consumer;

public class Day20Runner implements Consumer<InputProvider> {

    @Override
    public void accept(final InputProvider provider) {
        final var filepath = Path.of("src/main/resources/inputs/day20.txt");
        final var input = Integer.parseInt(provider.inputAsString(filepath));
        final var day = new Day20(input);
        System.out.println("Day 20, part I results: \n" + day.partI());
        System.out.println("Day 20, part II results: \n" + day.partII());
    }

}
