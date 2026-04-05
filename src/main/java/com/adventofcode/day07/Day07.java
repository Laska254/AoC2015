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
        if (line.contains("NOT")) {
            return parser.parse(line).execute(wires);
        }
        if (line.contains("AND") || line.contains("OR")) {
            return parser.parse(line).execute(wires);
        }
        if (line.contains("SHIFT")) {
            return parser.parse(line).execute(wires);
        }
        return false;
    }

}
