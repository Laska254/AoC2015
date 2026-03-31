package com.adventofcode.day06;

import com.adventofcode.day03.Coordinates;

public record Instruction(String command, Coordinates start, Coordinates end) {

    public static Instruction fromString(final String instruction) {
        final var command = parseCommand(instruction);
        if (instruction.split(" ").length == 5) {
            return new Instruction(command,
                    parseCoords(instruction, 2),
                    parseCoords(instruction, 4));
        } else {
            return new Instruction(command,
                    parseCoords(instruction, 1),
                    parseCoords(instruction, 3));
        }
    }

    private static String parseCommand(final String instruction) {
        final var split = instruction.split(" ");
        return instruction.contains("turn")
                ? split[0] + " " + split[1]
                : split[0];
    }

    private static Coordinates parseCoords(final String instruction, final int index) {
        final var split = instruction.split(" ");
        final var coords = split[index].split(",");
        return new Coordinates(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
    }

}
