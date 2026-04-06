package com.adventofcode.day07.instruction;

public class Parser {

    public Instruction parse(final String line) {
        final var split = line.split(" -> ");
        final var operation = split[0];
        final var target = split[1];
        final var tokens = operation.split(" ");
        return switch (tokens.length) {
            case 1 -> new Assign(tokens[0], target);
            case 2 -> new Not(tokens[1], target);
            case 3 -> switch (tokens[1]) {
                case "AND", "OR" -> new AndOr(tokens[0], tokens[1], tokens[2], target);
                case "LSHIFT", "RSHIFT" -> new Shift(tokens[0], tokens[1], Integer.parseInt(tokens[2]), target);
                default -> throw new IllegalArgumentException("Unknown operator: " + tokens[1]);
            };
            default -> throw new IllegalArgumentException("Unknown instruction: " + line);
        };
    }

}
