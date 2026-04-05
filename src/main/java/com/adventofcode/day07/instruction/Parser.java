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
        if (split.length == 5 && ("AND".equals(split[1]) || "OR".equals(split[1]))) {
            return parseAndOr(split);
        }
        if (split[1].contains("SHIFT")) {
            return parseShift(split);
        }
        throw new IllegalArgumentException("Unknown instruction: " + line);
    }

    private Instruction parseAssign(final String[] split) {
        return new Assign(split[0], split[2]);
    }

    private static Instruction parseNot(final String[] split) {
        return new Not(split[1], split[3]);
    }

    private static Instruction parseAndOr(final String[] split) {
        return new AndOr(split[0], split[1], split[2], split[4]);
    }

    private static Instruction parseShift(final String[] split) {
        return new Shift(split[0], split[1], Integer.parseInt(split[2]), split[4]);
    }

}
