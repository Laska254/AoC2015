package com.adventofcode.day09;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day09Test {

    private Day09 day;

    private static final List<String> EXAMPLE_INPUT = List.of(
            "London to Dublin = 464",
            "London to Belfast = 518",
            "Dublin to Belfast = 141"
    );

    @BeforeEach
    void setUp() {
        day = new Day09();
    }

    @Test
    void shouldReturnShortestDistance() {
        final var result = day.getResultDistance(EXAMPLE_INPUT, SearchType.SHORTEST);
        assertEquals(605, result);
    }

    @Test
    void shouldReturnLongestDistance() {
        final var result = day.getResultDistance(EXAMPLE_INPUT, SearchType.LONGEST);
        assertEquals(982, result);
    }

}
