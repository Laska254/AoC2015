package com.adventofcode.day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day02Test {

    private Day02 day02;

    @BeforeEach
    void setUp() {
        day02 = new Day02();
    }

    /* A present with dimensions `2x3x4` requires `2*6 + 2*12 + 2*8 = 52`
     square feet of wrapping paper plus 6 square feet of slack, for a total of 58 square feet.
     A present with dimensions `1x1x10` requires `2*1 + 2*10 + 2*10 = 42`
     square feet of wrapping paper plus 1 square foot of slack, for a total of 43 square feet.*/
    @ParameterizedTest
    @MethodSource("squareFeetExamples")
    void calculateSquareFeet_shouldCorrectlyCalculate(int length, int width, int height, int expected) {
        assertEquals(expected, day02.calculateSquareFeet(List.of(length, width, height)));
    }

    /* A present with dimensions `2x3x4` requires `2+2+3+3 = 10` feet of ribbon
     to wrap the present plus `2*3*4 = 24` feet of ribbon for the bow, for a total of 34 feet.
     A present with dimensions `1x1x10` requires `1+1+1+1 = 4` feet of ribbon
     to wrap the present plus `1*1*10 = 10` feet of ribbon for the bow, for a total of 14 feet. */
    @ParameterizedTest()
    @MethodSource("lengthExamples")
    void calculateLength_shouldCorrectlyCalculate(int length, int width, int height, int expected) {
        assertEquals(expected, day02.calculateSquareFeet(List.of(length, width, height)));
    }

    private static Stream<Arguments> squareFeetExamples() {
        return Stream.of(
                Arguments.of(List.of(2, 3, 4), 58),
                Arguments.of(List.of(1, 1, 10), 43)
        );
    }

    private static Stream<Arguments> lengthExamples() {
        return Stream.of(
                Arguments.of(List.of(2, 3, 4), 34),
                Arguments.of(List.of(1, 1, 10), 14)
        );
    }

}