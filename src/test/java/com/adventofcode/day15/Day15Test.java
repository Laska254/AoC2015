package com.adventofcode.day15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day15Test {

    private Day15 day;

    @BeforeEach
    void setUp() {
        final var input = List.of(
                "Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8",
                "Cinnamon: capacity 2, durability 3, flavor -2, texture -1, calories 3"
        );
        day = new Day15(input);
    }

    /*
    Given the ingredients above, if you had instead selected 40 teaspoons of butterscotch and 60 teaspoons of cinnamon
    (which still adds to 100), the total calorie count would be 40*8 + 60*3 = 500. The total score would go down,
    though: only 57600000, the best you can do in such trying circumstances.
     */
    @Test
    void testPartII() {
        assertEquals(57600000, day.run());
    }

}
