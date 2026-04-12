package com.adventofcode.day14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Nested
    class GetDistance {

        // After one second, Comet has gone 14 km, while Dancer has gone 16 km.
        @Test
        void after_1s() {
            day.run(1);
            assertEquals(16, day.getMaxDistance());
            assertEquals(14, day.getMinDistance());
        }

        // After ten seconds, Comet has gone 140 km, while Dancer has gone 160 km.
        @Test
        void after_10s() {
            day.run(10);
            assertEquals(160, day.getMaxDistance());
            assertEquals(140, day.getMinDistance());
        }

        // On the eleventh second, Comet begins resting (staying at 140 km), and Dancer continues on for a total distance of 176 km.
        @Test
        void after_11s() {
            day.run(11);
            assertEquals(176, day.getMaxDistance());
            assertEquals(140, day.getMinDistance());
        }

        // On the 12th second, both reindeer are resting.
        @Test
        void after_12s() {
            day.run(12);
            assertEquals(176, day.getMaxDistance());
            assertEquals(140, day.getMinDistance());
        }

        // They continue to rest until the 138th second, when Comet flies for another ten seconds.
        @Test
        void after_138s() {
            day.run(138);
            assertEquals(176, day.getMaxDistance());
            assertEquals(154, day.getMinDistance());
        }

        @Test
        void after_148s() {
            day.run(148);
            assertEquals(280, day.getMaxDistance());
            assertEquals(176, day.getMinDistance());
        }

        // On the 174th second, Dancer flies for another 11 seconds.
        @Test
        void after_174s() {
            day.run(174);
            assertEquals(280, day.getMaxDistance());
            assertEquals(192, day.getMinDistance());
        }

        @Test
        void after_184s() {
            day.run(184);
            assertEquals(352, day.getMaxDistance());
            assertEquals(280, day.getMinDistance());
        }

        /*
        In this example, after the 1000th second, both reindeer are resting,
        and Comet is in the lead at 1120 km (poor Dancer has only gotten 1056 km by that point).
        So, in this situation, Comet would win (if the race ended at 1000 seconds).
         */
        @Test
        void after_1000s() {
            day.run(1000);
            assertEquals(1120, day.getMaxDistance());
            assertEquals(1056, day.getMinDistance());
        }

    }

}
