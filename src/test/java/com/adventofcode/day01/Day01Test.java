package com.adventofcode.day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day01Test {

    private Day01 day01;

    @BeforeEach
    void setUp() {
        day01 = new Day01();
    }

    @Nested
    class CalculateFloor {

        // (()) and ()() both result in floor 0.
        @ParameterizedTest
        @ValueSource(strings = {"(())", "()()"})
        void shouldReturnZeroForBalancedParentheses_examples(String input) {
            assertEquals(0, day01.calculateFloor(toCharList(input)));
        }

        // ((( and (()(()( both result in floor 3.
        @ParameterizedTest
        @ValueSource(strings = {"(((", "(()(()(", "))((((("})
        void shouldReturnThreeForUpMovements_examples(String input) {
            assertEquals(3, day01.calculateFloor(toCharList(input)));
        }

        // ()) and ))( both result in floor -1 (the first basement level).
        @ParameterizedTest
        @ValueSource(strings = {"())", "))("})
        void shouldReturnMinusOne_examples(String input) {
            assertEquals(-1, day01.calculateFloor(toCharList(input)));
        }

        // ))) and )())()) both result in floor -3.
        @ParameterizedTest
        @ValueSource(strings = {")))", ")())())"})
        void shouldReturnMinusThree_examples(String input) {
            assertEquals(-3, day01.calculateFloor(toCharList(input)));
        }

    }

    @Nested
    class FindPositionOfBasementEnter {

        // `)` causes him to enter the basement at character position `1`.
        @Test
        void shouldFindBasementOnPosition1() {
            assertEquals(1, day01.findPositionOfBasementEnter(toCharList(")")));
        }


        // `()())` causes him to enter the basement at character position `5`.
        @Test
        void shouldFindBasementAtPositionFive_example() {
            assertEquals(5, day01.findPositionOfBasementEnter(toCharList("()())")));
        }

    }

    private List<Character> toCharList(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .toList();
    }

}