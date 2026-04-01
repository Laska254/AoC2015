package com.adventofcode.runner;

import com.adventofcode.InputProvider;
import com.adventofcode.day16.Day16;

import java.io.File;
import java.util.Map;
import java.util.function.Consumer;

public class Day16Runner implements Consumer<InputProvider> {

    @Override
    public void accept(final InputProvider provider) {
        final var file = new File("src/main/resources/inputs/day16.txt");
        final var input = provider.inputAsListOfStrings(file);
        final var tickerTape = Map.ofEntries(
                Map.entry("children", 3),
                Map.entry("cats", 7),
                Map.entry("samoyeds", 2),
                Map.entry("pomeranians", 3),
                Map.entry("akitas", 0),
                Map.entry("vizslas", 0),
                Map.entry("goldfish", 5),
                Map.entry("trees", 3),
                Map.entry("cars", 2),
                Map.entry("perfumes", 1));
        final var day = new Day16(input, tickerTape);
        System.out.println("Day 16, part I: " + day.findCorrectAuntI().index());
        System.out.println("Day 16, part II: " + day.findCorrectAuntII().index());
    }

}
