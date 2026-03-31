package com.adventofcode.day05;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Day05 {

    private static final Pattern THREE_VOWELS_PATTERN = Pattern.compile("(\\w*[aeiou]\\w*){3}");
    private static final Pattern ONE_LETTER_TWICE_IN_ROW_PATTERN = Pattern.compile("\\b\\w*(\\w)\\1\\w*\\b");
    private static final Pattern NO_BANNED_WORDS_PATTERN = Pattern.compile("^(?!.*(ab|cd|pq|xy)).*$");
    private static final Pattern PAIR_LETTERS_TWICE_WITHOUT_OVERLAPPING = Pattern.compile(".*([a-zA-Z]{2}).*\\1.*");
    private static final Pattern A_B_A_PATTERN = Pattern.compile(".*([a-z])\\w(\\1).*");

    private static final Map<CheckingMethod, List<Pattern>> RULES = Map.ofEntries(
            Map.entry(CheckingMethod.STANDARD, List.of(THREE_VOWELS_PATTERN, ONE_LETTER_TWICE_IN_ROW_PATTERN, NO_BANNED_WORDS_PATTERN)),
            Map.entry(CheckingMethod.BETTER, List.of(PAIR_LETTERS_TWICE_WITHOUT_OVERLAPPING, A_B_A_PATTERN))
    );

    public int howManyStringsAreNice(final List<String> list, final CheckingMethod method) {
        return (int) list.stream()
                .filter(word -> isNice(word, method))
                .count();
    }

    private boolean isNice(final String word, final CheckingMethod method) {
        return RULES.getOrDefault(method, List.of())
                .stream()
                .allMatch(pattern -> pattern.matcher(word).matches());
    }

}
