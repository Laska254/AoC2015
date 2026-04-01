package com.adventofcode.runner;

import com.adventofcode.InputProvider;
import com.adventofcode.day21.Day21;

import java.util.function.Consumer;

public class Day21Runner implements Consumer<InputProvider> {

    @Override
    public void accept(InputProvider provider) {
        final var day = new Day21();
        final var result = day.calculateMinimalGoldToWin();
        System.out.println("Day 21, part I result: " + result);
    }

}
