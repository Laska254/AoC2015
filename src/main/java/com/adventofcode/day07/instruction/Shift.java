package com.adventofcode.day07.instruction;

import java.util.Map;

public record Shift(String source, String operator, int amount, String target)
        implements Instruction {

    @Override
    public boolean execute(final Map<String, Character> wires) {
        if (!wires.containsKey(source)) {
            return false;
        }
        wires.put(target, compute(wires.get(source)));
        return true;
    }

    private char compute(final char value) {
        return switch (operator) {
            case "LSHIFT" -> (char) (value << amount);
            case "RSHIFT" -> (char) (value >> amount);
            default -> throw new IllegalStateException("Unexpected operator: " + operator);
        };
    }

}
