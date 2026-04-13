package com.adventofcode.day11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class Day11Test {

    private Day11 day;
    private Validator validator;

    @BeforeEach
    void setUp() {
        day = new Day11();
        validator = new Validator();
    }

    @ParameterizedTest
    @MethodSource("args")
    void generateNewPassword(String input, String expected) {
        assertEquals(expected, day.generateNewPassword(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"hijklmmn", "abbceffg", "abbcegjk"})
    void isValid_Fails(String input) {
        assertFalse(validator.isValid(new Password(input)));
    }

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("abcdefgh", "abcdffaa"),
                Arguments.of("ghijklmn", "ghjaabcc")
        );
    }

}