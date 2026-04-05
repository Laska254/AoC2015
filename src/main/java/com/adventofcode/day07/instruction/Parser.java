package com.adventofcode.day07.instruction;

public class Parser {

    public Instruction parse(final String line) {
        final String[] split = line.split(" ");
        if (split.length == 3) {
            return parseAssign(split);
        }
        throw new IllegalArgumentException("Unknown instruction: " + line);
    }

    private Instruction parseAssign(final String[] split) {
        return new Assign(split[0], split[2]);
    }

}
