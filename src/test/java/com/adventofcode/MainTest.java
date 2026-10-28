package com.adventofcode;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {

    @Nested
    class Line {

        @Test
        void shouldFormatDayPartAndAnswer() {
            assertEquals("Day 7 · part 1: 42", Main.line(7, 1, () -> 42));
        }

        @Test
        void shouldReportNotSolvedYetWhenPartTwoIsNotOverridden() {
            final Solution solution = input -> 0;
            assertEquals("Day 98 · part 2: not solved yet", Main.line(98, 2, () -> solution.partTwo("")));
        }

        // Mutating an immutable list is a bug in the day, not an unsolved part.
        @Test
        void shouldNotHideOtherUnsupportedOperations() {
            assertThrows(UnsupportedOperationException.class, () -> Main.line(7, 1, () -> List.of().add(1)));
        }

    }

}
