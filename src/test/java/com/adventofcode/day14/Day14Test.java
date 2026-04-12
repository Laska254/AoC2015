package com.adventofcode.day14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    // After one second, Comet has gone 14 km, while Dancer has gone 16 km.
    @Test
    void after_1s() {

    }

    // After ten seconds, Comet has gone 140 km, while Dancer has gone 160 km.
    @Test
    void after_10s() {

    }

    // On the eleventh second, Comet begins resting (staying at 140 km), and Dancer continues on for a total distance of 176 km.
    @Test
    void after_11s() {

    }

    // On the 12th second, both reindeer are resting.
    @Test
    void after_12s() {

    }

    // They continue to rest until the 138th second, when Comet flies for another ten seconds.
    @Test
    void after_138s() {

    }

    @Test
    void after_148s() {

    }

    // On the 174th second, Dancer flies for another 11 seconds.
    @Test
    void after_174s() {

    }

    @Test
    void after_184s() {

    }

    /*
    In this example, after the 1000th second, both reindeer are resting,
    and Comet is in the lead at 1120 km (poor Dancer has only gotten 1056 km by that point).
    So, in this situation, Comet would win (if the race ended at 1000 seconds).
     */
    @Test
    void after_1000s() {

    }

}
