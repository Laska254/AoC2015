package com.adventofcode.day11;

import com.adventofcode.day11.rule.BannedLetters;

public record Password(String value) {

    public Password incrementPassword() {
        final var chars = value.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != 'z') {
                ++chars[i];
                if (BannedLetters.BANNED_LETTERS.contains(chars[i])) {
                    chars[i]++;
                }
                break;
            } else {
                chars[i] = 'a';
            }
        }
        return new Password(new String(chars));
    }

    public int length() {
        return value.length();
    }

    public char charAt(final int index) {
        return value.charAt(index);
    }

}
