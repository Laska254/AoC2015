package com.adventofcode;

import com.adventofcode.runner.Day01Runner;
import com.adventofcode.runner.Day02Runner;
import com.adventofcode.runner.Day03Runner;
import com.adventofcode.runner.Day04Runner;
import com.adventofcode.runner.Day05Runner;
import com.adventofcode.runner.Day06Runner;
import com.adventofcode.runner.Day07Runner;
import com.adventofcode.runner.Day08Runner;
import com.adventofcode.runner.Day09Runner;
import com.adventofcode.runner.Day10Runner;
import com.adventofcode.runner.Day11Runner;
import com.adventofcode.runner.Day12Runner;
import com.adventofcode.runner.Day15Runner;
import com.adventofcode.runner.Day16Runner;
import com.adventofcode.runner.Day17Runner;
import com.adventofcode.runner.Day18Runner;
import com.adventofcode.runner.Day19Runner;
import com.adventofcode.runner.Day20Runner;
import com.adventofcode.runner.Day21Runner;

import java.nio.file.ProviderNotFoundException;
import java.util.Map;
import java.util.function.Consumer;

public final class Calendar {

    private static final Map<Integer, Consumer<InputProvider>> RUNNERS = Map.ofEntries(
            Map.entry(1, new Day01Runner()),
            Map.entry(2, new Day02Runner()),
            Map.entry(3, new Day03Runner()),
            Map.entry(4, new Day04Runner()),
            Map.entry(5, new Day05Runner()),
            Map.entry(6, new Day06Runner()),
            Map.entry(7, new Day07Runner()),
            Map.entry(8, new Day08Runner()),
            Map.entry(9, new Day09Runner()),
            Map.entry(10, new Day10Runner()),
            Map.entry(11, new Day11Runner()),
            Map.entry(12, new Day12Runner()),
            Map.entry(15, new Day15Runner()),
            Map.entry(16, new Day16Runner()),
            Map.entry(17, new Day17Runner()),
            Map.entry(18, new Day18Runner()),
            Map.entry(19, new Day19Runner()),
            Map.entry(20, new Day20Runner()),
            Map.entry(21, new Day21Runner())
    );

    public static Consumer<InputProvider> getRunner(int dayNumber) {
        final var provider = RUNNERS.get(dayNumber);
        if (provider == null) {
            throw new ProviderNotFoundException("Day " + dayNumber + " not implemented.");
        }
        return provider;
    }

}
