package com.adventofcode.day10;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Day10 {

    private static final Pattern PATTERN = Pattern.compile("(.)\\1*");

    public int lengthAfterIterations(final String originalInput, final int iterations) {
        return Stream.iterate(originalInput, this::lookAndSay)
                .skip(iterations)
                .findFirst()
                .orElse(originalInput)
                .length();
    }

    public String lookAndSay(final String input) {
        final var result = new StringBuilder();
        PATTERN.matcher(input).results().forEach(match -> {
            final var group = match.group();
            result.append(group.length()).append(group.charAt(0));
        });
        return result.toString();
    }

}
