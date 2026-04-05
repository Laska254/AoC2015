package com.adventofcode.day07.instruction;

import java.util.Map;

public interface Instruction {

    boolean execute(Map<String, Character> wires);

}
