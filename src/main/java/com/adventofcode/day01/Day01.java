package com.adventofcode.day01;

import com.adventofcode.Solution;

public class Day01 implements Solution {

    @Override
    public Integer partOne(final String input) {
        return input.chars()
                .map(this::checkFloor)
                .sum();
    }

    @Override
    public Integer partTwo(final String input) {
        var floor = 0;
        for (var position = 1; position <= input.length(); position++) {
            floor += checkFloor(input.charAt(position - 1));
            if (floor == -1) {
                return position;
            }
        }
        return 0;
    }

    private int checkFloor(final int character) {
        return switch (character) {
            case '(' -> 1;
            case ')' -> -1;
            default -> 0;
        };
    }

}
