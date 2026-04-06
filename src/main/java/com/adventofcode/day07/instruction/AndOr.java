package com.adventofcode.day07.instruction;

import java.util.Map;

public record AndOr(String left, String operator, String right, String target)
        implements Instruction {

    @Override
    public boolean execute(final Map<String, Character> wires) {
        final char leftValue = resolve(left, wires);
        final char rightValue = resolve(right, wires);
        if (leftValue == ' ' || rightValue == ' ') {
            return false;
        }
        wires.put(target, compute(leftValue, rightValue));
        return true;
    }

    private char compute(final char leftValue, final char rightValue) {
        return switch (operator) {
            case "AND" -> (char) (leftValue & rightValue);
            case "OR" -> (char) (leftValue | rightValue);
            default -> throw new IllegalStateException("Unexpected operator: " + operator);
        };
    }

    private char resolve(final String operand, final Map<String, Character> wires) {
        return operand.matches("\\d+")
                ? (char) Short.parseShort(operand)
                : wires.getOrDefault(operand, ' ');
    }

}
