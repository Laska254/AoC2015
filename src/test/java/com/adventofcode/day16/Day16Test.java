package com.adventofcode.day16;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day16Test {

    private Day16 day;

    // The puzzle gives no example aunts, so these are made up: Sue 2 matches the ticker tape exactly,
    // Sue 3 matches only with the part II ranges (cats greater than, pomeranians and goldfish fewer than).
    @BeforeEach
    void setUp() {
        final var input = List.of(
                "Sue 1: children: 1, cars: 2, perfumes: 1",
                "Sue 2: children: 3, cats: 7, samoyeds: 2",
                "Sue 3: cats: 8, pomeranians: 2, goldfish: 4"
        );
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
        day = new Day16(input, tickerTape);
    }

    @Test
    void testPartI() {
        assertEquals(2, day.findCorrectAuntI().index());
    }

    @Test
    void testPartII() {
        assertEquals(3, day.findCorrectAuntII().index());
    }

}
