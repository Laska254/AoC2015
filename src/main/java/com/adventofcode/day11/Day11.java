package com.adventofcode.day11;

import java.util.List;

public class Day11 {

    private static final List<Character> BANNED_LETTERS = List.of('i', 'o', 'l');
    private static final String TWO_DIFFERENT_NON_OVERLAPPING_PAIRS = "(?:([a-z])\\1.*([a-z])\\2|[a-z]*([a-z])\\3[a-z]*){2,}";

    public String generateNewPassword(final String oldPassword) {
        var newPassword = oldPassword;
        do {
            newPassword = incrementPassword(newPassword);
        } while (!checkIfValid(newPassword));
        return newPassword;
    }

    public boolean checkIfValid(final String password) {
        return increasingStraightOfThreeLetters(password)
                && !checkIfContainsBannedLetters(password)
                && password.matches(TWO_DIFFERENT_NON_OVERLAPPING_PAIRS);
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

    private boolean checkIfContainsBannedLetters(final String password) {
        return password.chars()
                .anyMatch(letter -> BANNED_LETTERS.contains((char) letter));
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
