package com.adventofcode.day05;

import java.util.List;
import java.util.Map;


public class Day05 {

    private static final Map<CheckingMethod, List<NicePattern>> RULES = Map.ofEntries(
            Map.entry(CheckingMethod.STANDARD, List.of(
                    NicePattern.THREE_VOWELS,
                    NicePattern.ONE_LETTER_TWICE_IN_ROW,
                    NicePattern.NO_BANNED_WORDS)),
            Map.entry(CheckingMethod.BETTER, List.of(
                    NicePattern.PAIR_LETTERS_TWICE_WITHOUT_OVERLAPPING,
                    NicePattern.A_B_A))
    );

    public int howManyStringsAreNice(final List<String> list, final CheckingMethod method) {
        return (int) list.stream()
                .filter(word -> isNice(word, method))
                .count();
    }

    public boolean isNice(final String word, final CheckingMethod method) {
        return RULES.getOrDefault(method, List.of())
                .stream()
                .allMatch(pattern -> pattern.matches(word));
    }

}
