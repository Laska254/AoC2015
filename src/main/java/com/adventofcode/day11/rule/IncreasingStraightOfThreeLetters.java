package com.adventofcode.day11.rule;

import com.adventofcode.day11.Password;

import java.util.stream.IntStream;

public record IncreasingStraightOfThreeLetters() implements PasswordRule {

    @Override
    public boolean isSatisfiedBy(final Password password) {
        return IntStream.range(0, password.length() - 2)
                .anyMatch(index -> password.charAt(index + 1) == password.charAt(index) + 1
                        && password.charAt(index + 2) == password.charAt(index) + 2);
    }

}
