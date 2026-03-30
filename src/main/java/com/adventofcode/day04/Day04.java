package com.adventofcode.day04;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day04 {

    private String calculateMD5(final String input) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException exception) {
            throw new RuntimeException("Algorithm not found.", exception);
        }
    }

    public int findLowestPossibleNumber(final String secretKey, final String requirement) {
        for (int number = 1; ; number++) {
            if (calculateMD5(secretKey + number).startsWith(requirement)) {
                return number;
            }
        }
    }

}
