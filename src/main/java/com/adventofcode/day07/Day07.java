package com.adventofcode.day07;

import com.adventofcode.day07.instruction.Parser;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day07 {

    private final Map<String, Character> wires = new HashMap<>();
    private final Parser parser = new Parser();

    public void simulate(final List<String> input) {
        final var instructions = input.stream()
                .map(parser::parse)
                .collect(Collectors.toCollection(LinkedList::new));
        while (!instructions.isEmpty()) {
            instructions.removeIf(instruction -> instruction.execute(wires));
        }
    }

    public int getWire(final String wire) {
        final Character value = wires.get(wire);
        if (value == null) {
            throw new IllegalStateException("Wire '%s' has not been resolved".formatted(wire));
        }
        return value;
    }

    public int partI(final List<String> input) {
        simulate(input);
        return wires.get("a");
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

}
