package com.adventofcode.day11.rule;

import com.adventofcode.day11.Password;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public record TwoDifferentPairs() implements PasswordRule {

    @Override
    public boolean isSatisfiedBy(final Password password) {
        return IntStream.range(0, password.length() - 1)
                .filter(i -> password.charAt(i) == password.charAt(i + 1))
                .mapToObj(password::charAt)
                .collect(Collectors.toSet())
                .size() >= 2;
    }

}
