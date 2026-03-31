package com.adventofcode.day06;

import com.adventofcode.day03.Coordinates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Day06 {
    private final static int SIZE = 1000;

    private final Map<Coordinates, Light> lights;

    public Day06() {
        lights = new HashMap<>();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                lights.put(new Coordinates(i, j), new Light());
            }
        }
    }

    public void run(final List<String> list) {
        final var instructions = new ArrayList<Instruction>();
        list.stream()
                .map(Instruction::fromString)
                .forEach(instructions::add);
        instructions.forEach(this::doInstruction);
    }

    public int howManyLightsAreLit() {
        return (int) lights.values()
                .stream()
                .filter(Light::state)
                .count();
    }

    public int totalBrightness() {
        return lights.values()
                .stream()
                .mapToInt(Light::brightness)
                .sum();
    }

    public void doInstruction(final Instruction instruction) {
        IntStream.rangeClosed(instruction.start().x(), instruction.end().x())
                .forEach(i -> IntStream.rangeClosed(instruction.start().y(), instruction.end().y())
                        .forEach(j -> {
                            final var coords = new Coordinates(i, j);
                            final var light = instruction.command().apply(lights.get(coords));
                            lights.put(coords, light);
                        }));
    }

}
