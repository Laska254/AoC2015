package com.adventofcode.day06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day06Test {

    private Day06 day06;

    @BeforeEach
    void setUp() {
        day06 = new Day06();
    }

    @Test
    void howManyLightsAreLit() {
        var expected = 1000000;
        // `turn on 0,0 through 999,999` would turn on (or leave on) every light.
        day06.doInstruction(Instruction.fromString("turn on 0,0 through 999,999"));
        assertEquals(expected, day06.howManyLightsAreLit());

        // `toggle 0,0 through 999,0` would toggle the first line of 1000 lights, turning off the ones that were on,
        // and turning on the ones that were off.
        day06.doInstruction(Instruction.fromString("toggle 0,0 through 999,0"));
        expected = expected - 1000;
        assertEquals(expected, day06.howManyLightsAreLit());

        // turn off 499,499 through 500,500 would turn off (or leave off) the middle four lights
        day06.doInstruction(Instruction.fromString("turn off 499,499 through 500,500"));
        expected = expected - 4;
        assertEquals(expected, day06.howManyLightsAreLit());
    }

    @Test
    void totalBrightness() {
        // turn on 0,0 through 0,0 would increase the total brightness by 1.
        var expected = 1;
        day06.doInstruction(Instruction.fromString("turn on 0,0 through 0,0"));
        assertEquals(expected, day06.totalBrightness());

        // toggle 0,0 through 999,999 would increase the total brightness by 2000000.
        expected = expected + 2000000;
        day06.doInstruction(Instruction.fromString("toggle 0,0 through 999,999"));
        assertEquals(expected, day06.totalBrightness());
    }

}