package com.adventofcode.day03;

import java.util.HashMap;
import java.util.List;

public class Day03 {

    public int deliverYourself(final List<Character> instructions) {
        final var visitedHouses = new HashMap<Coordinates, Integer>();
        var coords = new Coordinates(0, 0);
        visitedHouses.put(coords, visitedHouses.getOrDefault(coords, 0) + 1);
        for (char direction : instructions) {
            coords = move(coords, direction);
            visitedHouses.put(coords, visitedHouses.getOrDefault(coords, 0) + 1);
        }
        return visitedHouses.size();
    }

    public int deliverWithRobo(final List<Character> instructions) {
        final var visitedHouses = new HashMap<Coordinates, Integer>();
        var santaTurn = true;
        var santaCoords = new Coordinates(0, 0);
        var roboSantaCoords = new Coordinates(0, 0);
        visitedHouses.put(santaCoords, 2);
        for (char direction : instructions) {
            if (santaTurn) {
                santaCoords = move(santaCoords, direction);
                visitedHouses.put(santaCoords, visitedHouses.getOrDefault(santaCoords, 0) + 1);
            } else {
                roboSantaCoords = move(roboSantaCoords, direction);
                visitedHouses.put(roboSantaCoords, visitedHouses.getOrDefault(roboSantaCoords, 0) + 1);
            }
            santaTurn = !santaTurn;
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

}
