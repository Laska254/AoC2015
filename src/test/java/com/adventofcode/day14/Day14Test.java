package com.adventofcode.day14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day14Test {

    private Day14 day;

    @BeforeEach
    void setUp() {
        final var input = List.of(
                "Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.",
                "Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds."
        );
        day = new Day14(input);
    }

    @ParameterizedTest
    @MethodSource("argsPartI")
    void testPartI(final int seconds, final int expected) {
        day.run(seconds);
        assertEquals(expected, day.getMaxDistance());
    }

    @ParameterizedTest
    @MethodSource("argsPartII")
    void testPartII(final int seconds, final int expected) {
        day.run(seconds);
        assertEquals(expected, day.getMaxScore());
    }

    /*
    After one second, Comet has gone 14 km, while Dancer has gone 16 km.
    After ten seconds, Comet has gone 140 km, while Dancer has gone 160 km.
    On the eleventh second, Comet begins resting (staying at 140 km), and Dancer continues on for a total distance of 176 km.
    On the 12th second, both reindeer are resting.
    After the 1000th second, both reindeer are resting, and Comet is in the lead at 1120 km (poor Dancer has only gotten 1056 km by that point).
     */
    private static Stream<Arguments> argsPartI() {
        return Stream.of(
                Arguments.of(1, 16),
                Arguments.of(10, 160),
                Arguments.of(11, 176),
                Arguments.of(12, 176),
                Arguments.of(1000, 1120)
        );
    }

    /*
    After the first second, Dancer is in the lead and gets one point.
    After the 140th second, Comet pulls into the lead and gets his first point. Dancer has accumulated 139 points by the 140th second.
    After the 1000th second, Dancer has accumulated 689 points, while poor Comet, our old champion, only has 312.
     */
    private static Stream<Arguments> argsPartII() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(140, 139),
                Arguments.of(1000, 689)
        );
    }

}
