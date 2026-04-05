package com.adventofcode.day07.instruction;

public class Parser {

    public Instruction parse(final String line) {
        final String[] split = line.split(" ");
        if (split.length == 3) {
            return parseAssign(split);
        }
        if (split.length == 4 && "NOT".equals(split[0])) {
            return parseNot(split);
        }
        throw new IllegalArgumentException("Unknown instruction: " + line);
    }

    private Instruction parseAssign(final String[] split) {
        return new Assign(split[0], split[2]);
    }

    private static Instruction parseNot(final String[] split) {
        return new Not(split[1], split[3]);
    }

}
