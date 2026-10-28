package com.adventofcode.day12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day12Test {

    private Day12 day;

    @BeforeEach
    void setUp() {
        day = new Day12();
    }

    @ParameterizedTest
    @MethodSource("argsPartI")
    void testPartI(final String json, final int expected, @TempDir final Path dir) throws IOException {
        final var file = Files.writeString(dir.resolve("input.json"), json);
        assertEquals(expected, day.calculateSum(file));
    }

    /*
    [1,2,3] and {"a":2,"b":4} both have a sum of 6.
    [[[3]]] and {"a":{"b":4},"c":-1} both have a sum of 3.
    {"a":[-1,1]} and [-1,{"a":1}] both have a sum of 0.
    [] and {} both have a sum of 0.
     */
    private static Stream<Arguments> argsPartI() {
        return Stream.of(
                Arguments.of("[1,2,3]", 6),
                Arguments.of("{\"a\":2,\"b\":4}", 6),
                Arguments.of("[[[3]]]", 3),
                Arguments.of("{\"a\":{\"b\":4},\"c\":-1}", 3),
                Arguments.of("{\"a\":[-1,1]}", 0),
                Arguments.of("[-1,{\"a\":1}]", 0),
                Arguments.of("[]", 0),
                Arguments.of("{}", 0)
        );
    }

}
