package com.adventofcode.day03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day03 {

    public int deliver(final List<Character> instructions, final int workers) {
        final var visitedHouses = new HashMap<Coordinates, Integer>();
        final var positions = new Coordinates[workers];
        Arrays.fill(positions, new Coordinates(0, 0));
        visit(visitedHouses, positions[0]);
        for (int i = 0; i < instructions.size(); i++) {
            final int idx = i % workers;
            positions[idx] = move(positions[idx], instructions.get(i));
            visit(visitedHouses, positions[idx]);
        }
        return visitedHouses.size();
    }

    private Coordinates move(final Coordinates coords, final char direction) {
        return switch (direction) {
            case '>' -> coords.withX(coords.x() + 1);
            case '<' -> coords.withX(coords.x() - 1);
            case '^' -> coords.withY(coords.y() + 1);
            case 'v' -> coords.withY(coords.y() - 1);
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        };
    }

    private void visit(final Map<Coordinates, Integer> houses, final Coordinates coords) {
        houses.merge(coords, 1, Integer::sum);
    }

}
