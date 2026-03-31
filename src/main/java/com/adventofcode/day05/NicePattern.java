package com.adventofcode.day05;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public enum NicePattern {
    THREE_VOWELS("(\\w*[aeiou]\\w*){3}", CheckingMethod.STANDARD),
    ONE_LETTER_TWICE_IN_ROW("\\b\\w*(\\w)\\1\\w*\\b", CheckingMethod.STANDARD),
    NO_BANNED_WORDS("^(?!.*(ab|cd|pq|xy)).*$", CheckingMethod.STANDARD),
    PAIR_LETTERS_TWICE_WITHOUT_OVERLAPPING(".*([a-zA-Z]{2}).*\\1.*", CheckingMethod.BETTER),
    A_B_A(".*([a-z])\\w(\\1).*", CheckingMethod.BETTER);

    private final Pattern pattern;
    private final CheckingMethod method;

    NicePattern(final String regex, final CheckingMethod method) {
        this.pattern = Pattern.compile(regex);
        this.method = method;
    }

    boolean matches(final String word) {
        return pattern.matcher(word).matches();
    }

    public static List<NicePattern> patternsFor(final CheckingMethod method) {
        return Arrays.stream(values())
                .filter(p -> p.method == method)
                .toList();
    }

}
