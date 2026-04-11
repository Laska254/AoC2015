package com.adventofcode.day11.rule;

import com.adventofcode.day11.Password;

import java.util.Set;

public record BannedLetters() implements PasswordRule {

    public static final Set<Character> BANNED_LETTERS = Set.of('i', 'o', 'l');

    @Override
    public boolean isSatisfiedBy(final Password password) {
        return password.value().chars()
                .noneMatch(letter -> BANNED_LETTERS.contains((char) letter));
    }

}
