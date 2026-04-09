package com.adventofcode.day11;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day11 {

    private static final List<Character> BANNED_LETTERS = List.of('i', 'o', 'l');

    public String generateNewPassword(final String oldPassword) {
        return Stream.iterate(oldPassword, this::incrementPassword)
                .skip(1)
                .filter(this::isValid)
                .findFirst()
                .orElseThrow();
    }

    public boolean isValid(final String password) {
        return increasingStraightOfThreeLetters(password)
                && !hasBannedLetters(password)
                && hasTwoDifferentPairs(password);
    }

    private boolean increasingStraightOfThreeLetters(final String password) {
        return IntStream.range(0, password.length() - 2)
                .anyMatch(i -> password.charAt(i + 1) == password.charAt(i) + 1
                        && password.charAt(i + 2) == password.charAt(i) + 2);
    }

    private boolean hasBannedLetters(final String password) {
        return password.chars()
                .anyMatch(letter -> BANNED_LETTERS.contains((char) letter));
    }

    private boolean hasTwoDifferentPairs(final String password) {
        return IntStream.range(0, password.length() - 1)
                .filter(i -> password.charAt(i) == password.charAt(i + 1))
                .mapToObj(password::charAt)
                .collect(Collectors.toSet())
                .size() >= 2;
    }

    private String incrementPassword(final String password) {
        final var chars = password.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != 'z') {
                ++chars[i];
                break;
            } else {
                chars[i] = 'a';
            }
        }
        return new String(chars);
    }

}
