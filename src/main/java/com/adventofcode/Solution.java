package com.adventofcode;

/**
 * One Advent of Code day, found by {@link Days} through reflection.
 * <ul>
 *   <li>Name it {@code com.adventofcode.dayNN.DayNN}, with a two-digit day.</li>
 *   <li>Give it a public no-arg constructor.</li>
 *   <li>Return the bare answer; never print.</li>
 *   <li>Leave {@link #partTwo} unimplemented until part two is solved; the default means "not solved yet".</li>
 * </ul>
 */
public interface Solution {

    Object partOne(final String input);

    default Object partTwo(final String input) {
        throw new UnsupportedOperationException();
    }

}
