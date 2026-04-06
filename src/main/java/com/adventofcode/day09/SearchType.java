package com.adventofcode.day09;

import java.util.function.BiFunction;

public enum SearchType {

    SHORTEST(Integer.MAX_VALUE, (a, b) -> a < b),
    LONGEST(0, (a, b) -> a > b);

    private final int initDistance;
    private final BiFunction<Integer, Integer, Boolean> comparator;

    SearchType(final int initDistance, final BiFunction<Integer, Integer, Boolean> comparator) {
        this.initDistance = initDistance;
        this.comparator = comparator;
    }

    public int getInitDistance() {
        return initDistance;
    }

    public boolean isBetter(final int candidate, final int current) {
        return comparator.apply(candidate, current);
    }

}
