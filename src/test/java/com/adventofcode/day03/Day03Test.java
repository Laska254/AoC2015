package com.adventofcode.day03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day03Test {

    private Day03 day03;

    @BeforeEach
    void setUp() {
        day03 = new Day03();
    }

    /*
    > delivers presents to 2 houses: one at the starting location, and one to the east.
    ^>v< delivers presents to 4 houses in a square, including twice to the house at his starting/ending location.
    ^v^v^v^v^v delivers a bunch of presents to some very lucky children at only 2 houses.
     */
    @ParameterizedTest
    @MethodSource("deliverYourselfArgs")
    void deliverYourself(String instructions, int expectedHouses) {
        assertEquals(expectedHouses, day03.deliver(instructions, 1));
    }

    /*
     ^v delivers presents to 3 houses, because Santa goes north, and then Robo-Santa goes south.
     ^>v< now delivers presents to 3 houses, and Santa and Robo-Santa end up back where they started.
     ^v^v^v^v^v now delivers presents to 11 houses, with Santa going one direction and Robo-Santa going the other.
    */
    @ParameterizedTest
    @MethodSource("deliverWithRoboArgs")
    void deliverWithRobo(String instructions, int expectedHouses) {
        assertEquals(expectedHouses, day03.deliver(instructions, 2));
    }


    private static Stream<Arguments> deliverYourselfArgs() {
        return Stream.of(
                Arguments.of(">", 2),
                Arguments.of("^>v<", 4),
                Arguments.of("^v^v^v^v^v", 2)
        );
    }

    private static Stream<Arguments> deliverWithRoboArgs() {
        return Stream.of(
                Arguments.of("^v", 3),
                Arguments.of("^>v<", 3),
                Arguments.of("^v^v^v^v^v", 11)
        );
    }

}