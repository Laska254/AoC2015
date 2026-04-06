package com.adventofcode.day07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day07Test {

    private static final List<String> SAMPLE = List.of(
            "123 -> x",
            "456 -> y",
            "x AND y -> d",
            "x OR y -> e",
            "x LSHIFT 2 -> f",
            "y RSHIFT 2 -> g",
            "NOT x -> h",
            "NOT y -> i"
    );

    private Day07 day;

    @BeforeEach
    void setUp() {
        day = new Day07();
    }

    @Test
    void allWiresResolveToExpectedValues() {
        day.simulate(SAMPLE);

        assertEquals(72, day.getWire("d"));
        assertEquals(507, day.getWire("e"));
        assertEquals(492, day.getWire("f"));
        assertEquals(114, day.getWire("g"));
        assertEquals(65412, day.getWire("h"));
        assertEquals(65079, day.getWire("i"));
        assertEquals(123, day.getWire("x"));
        assertEquals(456, day.getWire("y"));
    }

}
