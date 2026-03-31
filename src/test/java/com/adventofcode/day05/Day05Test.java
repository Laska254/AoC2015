package com.adventofcode.day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day05Test {
    private Day05 day05;

    @BeforeEach
    void setUp() {
        day05 = new Day05();
    }

    @ParameterizedTest
    @MethodSource("standardArgs")
    void shouldEvaluateNiceness_whenUsingStandardMethod(String word, boolean expected) {
        assertEquals(expected, day05.isNice(word, CheckingMethod.STANDARD));
    }

    @ParameterizedTest
    @MethodSource("betterArgs")
    void shouldEvaluateNiceness_whenUsingBetterMethod(String word, boolean expected) {
        assertEquals(expected, day05.isNice(word, CheckingMethod.BETTER));
    }

    private static Stream<Arguments> standardArgs() {
        return Stream.of(
                Arguments.of("ugknbfddgicrmopn", true),
                Arguments.of("aaa", true),
                Arguments.of("jchzalrnumimnmhp", false),
                Arguments.of("haegwjzuvuyypxyu", false),
                Arguments.of("dvszwmarrgswjxmb", false)
        );
    }

    private static Stream<Arguments> betterArgs() {
        return Stream.of(
                Arguments.of("qjhvhtzxzqqjkmpb", true),
                Arguments.of("xxyxx", true),
                Arguments.of("uurcxstgmygtbstg", false),
                Arguments.of("ieodomkazucvgmuy", false)
        );
    }

}