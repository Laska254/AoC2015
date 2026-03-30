package com.adventofcode.day01;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Day01 {

    public int calculateFloor(final List<Character> inputList) {
        return inputList.stream()
                .mapToInt(this::checkFloor)
                .sum();
    }

    public int findPositionOfBasementEnter(List<Character> inputList) {
        final var floor = new AtomicInteger(0);
        return IntStream.rangeClosed(1, inputList.size())
                .filter(i -> floor.addAndGet(checkFloor(inputList.get(i - 1))) == -1)
                .findFirst()
                .orElse(0);
    }

    private int checkFloor(final char character) {
        return switch (character) {
            case '(' -> 1;
            case ')' -> -1;
            default -> 0;
        };
    }

}
