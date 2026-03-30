package com.adventofcode.day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day04Test {

    private Day04 day04;

    @BeforeEach
    void setUp() {
        day04 = new Day04();
    }

    /*
    If your secret key is `abcdef`, the answer is `609043`, because the MD5 hash of `abcdef609043` starts with five
    zeroes (`000001dbbfa...`), and it is the lowest such number to do so.
    If your secret key is `pqrstuv`, the lowest number it combines with to make an MD5 hash starting with five zeroes is
    `1048970`; that is, the MD5 hash of `pqrstuv1048970` looks like `000006136ef...`.
    */
    @ParameterizedTest
    @MethodSource("args")
    void findLowestPossibleNumber(String secretKey, String requirements, int expected) {
        assertEquals(expected, day04.findLowestPossibleNumber(secretKey, requirements));
    }

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("abcdef", "00000", 609043),
                Arguments.of("pqrstuv", "00000", 1048970)
        );
    }

}