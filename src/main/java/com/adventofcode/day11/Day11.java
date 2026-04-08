package com.adventofcode.day11;

import java.util.HashSet;
import java.util.List;

public class Day11 {

    private static final List<Character> BANNED_LETTERS = List.of('i', 'o', 'l');

    public String generateNewPassword(final String oldPassword) {
        var newPassword = oldPassword;
        do {
            newPassword = incrementPassword(newPassword);
        } while (!checkIfValid(newPassword));
        return newPassword;
    }

    public boolean checkIfValid(final String password) {
        return increasingStraightOfThreeLetters(password)
                && !hasBannedLetters(password)
                && hasTwoDifferentPairs(password);
    }

    private boolean increasingStraightOfThreeLetters(final String password) {
        for (int i = 0; i < password.length() - 2; i++) {
            final var first = password.charAt(i);
            final var second = (char) (first + 1);
            final var third = (char) (first + 2);
            if (password.charAt(i + 1) == second && password.charAt(i + 2) == third) {
                return true;
            }
        }
        return false;
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
