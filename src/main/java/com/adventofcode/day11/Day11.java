package com.adventofcode.day11;

import java.util.stream.Stream;

public class Day11 {

    private final Validator validator = new Validator();

    public String generateNewPassword(final String oldPassword) {
        return Stream.iterate(new Password(oldPassword), Password::incrementPassword)
                .skip(1)
                .filter(validator::isValid)
                .map(Password::value)
                .findFirst()
                .orElseThrow();
    }

}
