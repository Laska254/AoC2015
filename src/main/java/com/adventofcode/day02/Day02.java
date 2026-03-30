package com.adventofcode.day02;

import java.util.List;

public class Day02 {

    public int getTotalSquareFeet(final List<List<Integer>> listOfDimensions) {
        return listOfDimensions.stream()
                .mapToInt(this::calculateSquareFeet)
                .sum();
    }

    public int getTotalLength(final List<List<Integer>> listOfDimensions) {
        return listOfDimensions.stream()
                .mapToInt(this::calculateLength)
                .sum();
    }

    public int calculateSquareFeet(final List<Integer> dimensions) {
        final var area1 = 2 * dimensions.get(0) * dimensions.get(2);
        final var area2 = 2 * dimensions.get(2) * dimensions.get(1);
        final var area3 = 2 * dimensions.get(1) * dimensions.get(0);
        final var slack = Math.min(Math.min(area1, area2), area3) / 2;
        return area1 + area2 + area3 + slack;
    }

    public int calculateLength(final List<Integer> dimensions) {
        final var sorted = dimensions.stream().sorted().toList();
        final var ribbon = (2 * sorted.get(0)) + (2 * sorted.get(1));
        final var bow = dimensions.get(0) * dimensions.get(1) * dimensions.get(2);
        return ribbon + bow;
    }

}
