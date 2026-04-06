package com.adventofcode.day07.instruction;

import java.util.Map;

public sealed interface Instruction permits AndOr, Assign, Not, Shift {

    boolean execute(Map<String, Character> wires);

}
