package com.adventofcode.day05;

import java.util.regex.Pattern;

public enum NicePattern {
    THREE_VOWELS("(\\w*[aeiou]\\w*){3}"),
    ONE_LETTER_TWICE_IN_ROW("\\b\\w*(\\w)\\1\\w*\\b"),
    NO_BANNED_WORDS("^(?!.*(ab|cd|pq|xy)).*$"),
    PAIR_LETTERS_TWICE_WITHOUT_OVERLAPPING(".*([a-zA-Z]{2}).*\\1.*"),
    A_B_A(".*([a-z])\\w(\\1).*");

    private final Pattern pattern;

    NicePattern(final String regex) {
        this.pattern = Pattern.compile(regex);
    }

    boolean matches(final String word) {
        return pattern.matcher(word).matches();
    }

}
