package com.adventofcode.day10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day10Test {

    private Day10 day;

    @BeforeEach
    void setUp() {
        day = new Day10();
    }

    @Test
    void lengthAfterIterations() {
        final var given = "1";
        final var iterations = 5;
        final var expected = 6;

        final var result = day.lengthAfterIterations(given, iterations);

        assertEquals(expected, result);
    }


    @Test
    void lookAndSay() {
        final var given = "111221";
        final var expected = "312211";

        assertEquals(expected, day.lookAndSay(given));
    }

}