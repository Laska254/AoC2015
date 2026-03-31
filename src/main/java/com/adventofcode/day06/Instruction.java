package com.adventofcode.day06;

import com.adventofcode.day03.Coordinates;

import java.util.regex.Pattern;

public record Instruction(Command command, Coordinates start, Coordinates end) {

    private static final Pattern PATTERN = Pattern.compile(
            "(turn on|turn off|toggle) (\\d+),(\\d+) through (\\d+),(\\d+)"
    );

    public static Instruction fromString(final String instruction) {
        final var matcher = PATTERN.matcher(instruction);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid instruction: " + instruction);
        }
        return new Instruction(
                Command.fromString(matcher.group(1)),
                new Coordinates(Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3))),
                new Coordinates(Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)))
        );
    }

}
