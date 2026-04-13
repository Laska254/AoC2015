package com.adventofcode.day11;

import com.adventofcode.day11.rule.BannedLetters;

public record Password(String value) {

    public Password incrementPassword() {
        return new Password(increment(value.toCharArray(), value.length() - 1));
    }

    private String increment(char[] chars, int i) {
        if (chars[i] != 'z') {
            ++chars[i];
            if (BannedLetters.BANNED_LETTERS.contains(chars[i])) {
                ++chars[i];
            }
        } else {
            chars[i] = 'a';
            increment(chars, i - 1);
        }
        return new String(chars);
    }

    public int length() {
        return value.length();
    }

    public char charAt(final int index) {
        return value.charAt(index);
    }

}
