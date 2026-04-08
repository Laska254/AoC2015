package com.adventofcode.day10;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
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
        return PATTERN.matcher(input).results()
                .map(MatchResult::group)
                .map(this::encodeGroup)
                .collect(Collectors.joining());
    }

    private String encodeGroup(final String group) {
        return "%d%s".formatted(group.length(), group.charAt(0));
    }

}
