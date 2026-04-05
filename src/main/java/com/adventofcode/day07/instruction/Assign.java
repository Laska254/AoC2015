package com.adventofcode.day07.instruction;

import java.util.Map;

public record Assign(String source, String target)
        implements Instruction {

    @Override
    public boolean execute(final Map<String, Character> wires) {
        if (source.matches("\\d+")) {
            wires.put(target, (char) Integer.parseInt(source));
            return true;
        }
        if (wires.containsKey(source)) {
            wires.put(target, wires.get(source));
            return true;
        }
        return false;
    }

}
