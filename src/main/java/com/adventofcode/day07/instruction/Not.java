package com.adventofcode.day07.instruction;

import java.util.Map;

public record Not(String source, String target)
        implements Instruction {

    @Override
    public boolean execute(final Map<String, Character> wires) {
        if (!wires.containsKey(source)) {
            return false;
        }
        wires.put(target, (char) ~wires.get(source));
        return true;
    }

}
