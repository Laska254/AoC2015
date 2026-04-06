package com.adventofcode.day08;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day08Test {

    private Day08 day;

    @BeforeEach
    void setUp() {
        day = new Day08();
    }


    @ParameterizedTest
    @MethodSource("argsPartI")
    void testPartI(String input, int expected) {
        assertEquals(expected, day.calculate(List.of(input)));
    }

    @ParameterizedTest
    @MethodSource("argsPartII")
    void testPartII(String input, int expected) {
        assertEquals(expected, day.calculateEncoded(List.of(input)));
    }

    /*
    "" is 2 characters of code (the two double quotes), but the string contains zero characters.
    "abc" is 5 characters of code, but 3 characters in the string data.
    "aaa\"aaa" is 10 characters of code, but the string itself contains six "a" characters and a single, escaped quote character, for a total of 7 characters in the string data.
    "\x27" is 6 characters of code, but the string itself contains just one - an apostrophe ('), escaped using hexadecimal notation.
     */
    private static Stream<Arguments> argsPartI() {
        return Stream.of(
                Arguments.of("\"\"", 2),
                Arguments.of("\"abc\"", 2),
                Arguments.of("\"aaa\\\"aaa\"", 3),
                Arguments.of("\"\\x27\"", 5)
        );
    }

    /*
    "" encodes to "\"\"", an increase from 2 characters to 6.
    "abc" encodes to "\"abc\"", an increase from 5 characters to 9.
    "aaa\"aaa" encodes to "\"aaa\\\"aaa\"", an increase from 10 characters to 16.
    "\x27" encodes to "\"\\x27\"", an increase from 6 characters to 11.
     */
    private static Stream<Arguments> argsPartII() {
        return Stream.of(
                Arguments.of("\"\"", 4),
                Arguments.of("\"abc\"", 4),
                Arguments.of("\"aaa\\\"aaa\"", 6),
                Arguments.of("\"\\x27\"", 5)
        );
    }

}
