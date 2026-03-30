package com.adventofcode.day04;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class Day04 {

    private final MessageDigest md5;

    public Day04() {
        try {
            this.md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found.", e);
        }
    }

    private String calculateMD5(final String input) {
        md5.reset();
        return HexFormat.of().formatHex(md5.digest(input.getBytes()));
    }

    public int findLowestPossibleNumber(final String secretKey, final String requirement) {
        for (int number = 1; ; number++) {
            if (calculateMD5(secretKey + number).startsWith(requirement)) {
                return number;
            }
        }
    }

}
