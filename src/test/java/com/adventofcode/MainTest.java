package com.adventofcode;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Nested
    class Line {

        @Test
        void shouldFormatDayPartAndAnswer() {
            assertEquals("Day 1 · part 1: 42", Main.line(1, 1, () -> 42));
        }

        @Test
        void shouldReportNotSolvedYetWhenPartTwoIsNotOverridden() {
            final Solution solution = input -> 0;
            assertEquals("Day 98 · part 2: not solved yet", Main.line(98, 2, () -> solution.partTwo("")));
        }

    }

}
