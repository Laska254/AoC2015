package com.adventofcode;

public interface Solution {

    Object partOne(final String input);

    default Object partTwo(final String input) {
        throw new UnsupportedOperationException();
    }

}
