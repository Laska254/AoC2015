package com.adventofcode.day05;

import java.util.List;


public class Day05 {

    public int howManyStringsAreNice(final List<String> list, final CheckingMethod method) {
        return (int) list.stream()
                .filter(word -> isNice(word, method))
                .count();
    }

    public boolean isNice(final String word, final CheckingMethod method) {
        return NicePattern.patternsFor(method)
                .stream()
                .allMatch(pattern -> pattern.matches(word));
    }

}
