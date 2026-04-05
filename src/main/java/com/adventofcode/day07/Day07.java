package com.adventofcode.day07;

import com.adventofcode.day07.instruction.Parser;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Day07 {

    private final Map<String, Character> wires = new HashMap<>();
    private final Parser parser = new Parser();

    public int partI(final List<String> input) {
        simulate(input);
        return wires.get("a");
    }

    public int getWire(final String wire) {
        final Character value = wires.get(wire);
        if (value == null) {
            throw new IllegalStateException("Wire '%s' has not been resolved".formatted(wire));
        }
        return value;
    }

    public void simulate(final List<String> input) {
        final var instructions = new LinkedList<>(input);
        while (!instructions.isEmpty()) {
            instructions.removeIf(this::doCommand);
        }
    }

    public int partII(final List<String> input) {
        final var value = wires.get("a");
        wires.clear();
        wires.put("b", value);
        final var instructions = new LinkedList<>(input);
        instructions.removeIf(line -> isToRemove(line.split(" ")));
        return partI(instructions);
    }

    private boolean isToRemove(final String[] split) {
        return split.length == 3 && split[2].matches("b");
    }

    private boolean doCommand(final String line) {
        final var split = line.split(" ");
        if (split.length == 3) {
            return parser.parse(line).execute(wires);
        }
        if (line.contains("NOT") && wires.containsKey(split[1])) {
            return handleNot(line);
        }
        if (line.contains("AND") || line.contains("OR")) {
            return handleAndOr(split);
        }
        if (line.contains("SHIFT")) {
            return handleShift(split);
        }
        return false;
    }

    private boolean updateWireIfValid(final String key, final char value) {
        if (!key.isBlank() && value != ' ') {
            wires.put(key, value);
            return true;
        }
        return false;
    }

    private boolean handleNot(final String line) {
        String[] split = line.split(" ");
        return updateWireIfValid(split[3], (char) ~wires.get(split[1]));
    }

    private boolean handleAndOr(final String[] split) {
        return updateWireIfValid(split[4], getValue2(split));
    }

    private char getValue2(final String[] split) {
        if (wires.containsKey(split[0]) && wires.containsKey(split[2])) {
            return switch (split[1]) {
                case "AND" -> (char) (wires.get(split[0]) & wires.get(split[2]));
                case "OR" -> (char) (wires.get(split[0]) | wires.get(split[2]));
                default -> throw new IllegalStateException("Unexpected value: " + split[1]);
            };
        }
        if (split[0].matches("\\d+") && wires.containsKey(split[2])) {
            return (char) (Short.parseShort(split[0]) & wires.get(split[2]));
        }
        return ' ';
    }

    private boolean handleShift(final String[] split) {
        return updateWireIfValid(split[4], getValue3(split));
    }

    private char getValue3(final String[] split) {
        if (!wires.containsKey(split[0])) {
            return ' ';
        }
        char shiftValue = (char) Integer.parseInt(split[2]);
        return switch (split[1]) {
            case "LSHIFT" -> (char) (wires.get(split[0]) << shiftValue);
            case "RSHIFT" -> (char) (wires.get(split[0]) >> shiftValue);
            default -> throw new IllegalStateException("Unexpected value: " + split[1]);
        };
    }

}
