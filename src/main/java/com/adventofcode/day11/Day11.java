package com.adventofcode.day11;

import java.util.HashSet;
import java.util.List;
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
        final var pairs = new HashSet<>();
        var i = 0;
        while (i < password.length() - 1) {
            if (password.charAt(i) == password.charAt(i + 1)) {
                pairs.add(password.charAt(i));
                i += 2;
            } else {
                i++;
            }
        }
        return pairs.size() >= 2;
    }

    private String incrementPassword(final String password) {
        final var chars = password.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == 'z') {
                chars[i] = 'a';
            } else {
                chars[i] = (char) (chars[i] + 1);
                break;
            }
        }
        return new String(chars);
    }

}
