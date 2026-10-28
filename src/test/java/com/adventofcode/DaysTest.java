package com.adventofcode;

import com.adventofcode.day01.Day01;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DaysTest {

    @Nested
    class FindSolution {

        @Test
        void shouldFindDayByNamingConvention() {
            assertInstanceOf(Day01.class, Days.solution(1).orElseThrow());
        }

        @Test
        void shouldReturnEmptyWhenDayClassIsMissing() {
            assertTrue(Days.solution(99).isEmpty());
        }

        @Test
        void shouldReturnEmptyWhenDayIsNotASolution() {
            assertTrue(Days.solution(97).isEmpty());
        }

        @Test
        void shouldFailWhenSolutionHasNoNoArgConstructor() {
            final var exception = assertThrows(IllegalStateException.class, () -> Days.solution(98));
            assertEquals("com.adventofcode.day98.Day98 needs a public no-arg constructor", exception.getMessage());
        }

        @Test
        void shouldReportConstructorFailureWithItsCause() {
            final var exception = assertThrows(IllegalStateException.class, () -> Days.solution(96));
            assertEquals("com.adventofcode.day96.Day96 failed to construct", exception.getMessage());
            assertInstanceOf(IllegalArgumentException.class, exception.getCause());
        }

    }

    @Nested
    class LoadInput {

        @Test
        void shouldLoadInputFromClasspathWithoutTrailingWhitespace() {
            assertEquals("first line\nsecond line", Days.input(99).orElseThrow());
        }

        @Test
        void shouldReturnEmptyWhenInputIsMissing() {
            assertTrue(Days.input(97).isEmpty());
        }

        @Test
        void shouldPadDayNumberInInputPath() {
            assertEquals("inputs/day01.txt", Days.inputPath(1));
        }

    }

}
