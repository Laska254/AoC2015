package com.adventofcode.runner;

import com.adventofcode.InputProvider;
import com.adventofcode.day10.Day10;

import java.util.function.Consumer;

public class Day10Runner implements Consumer<InputProvider> {

    @Override
    public void accept(final InputProvider provider) {
        final var input = "3113322113";
        final var day = new Day10();
        System.out.println("Day 10, part I result: " + day.lengthAfterIterations(input, 40));
        System.out.println("Day 10, part II result: " + day.lengthAfterIterations(input, 50));
    }

}
