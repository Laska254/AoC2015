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
            assertThrows(IllegalStateException.class, () -> Days.solution(98));
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
