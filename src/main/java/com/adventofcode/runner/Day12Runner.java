package com.adventofcode.runner;

import com.adventofcode.InputProvider;
import com.adventofcode.day12.Day12;

import java.io.File;
import java.util.function.Consumer;

public class Day12Runner implements Consumer<InputProvider> {

    @Override
    public void accept(final InputProvider provider) {
        final var file = new File("src/main/resources/inputs/day12.json");
        final var day = new Day12();
        System.out.println("Day 12, part I result: " + day.calculateSum(file));
    }

}
