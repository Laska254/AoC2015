package com.adventofcode.day17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day17Test {

    private Day17 day;

    @BeforeEach
    void setUp() {
        day = new Day17(List.of(20, 15, 10, 5, 5), 25);
        day.run();
    }

    /*
    Suppose you have containers of size 20, 15, 10, 5, and 5 liters. If you need to store 25 liters,
    there are four ways to do it.
     */
    @Test
    void testPartI() {
        assertEquals(4, day.getCombinations());
    }

    /*
    In the example above, the minimum number of containers was two.
    There were three ways to use that many containers.
     */
    @Test
    void testPartII() {
        assertEquals(3, day.getWaysWithMinimumContainers());
    }

}
