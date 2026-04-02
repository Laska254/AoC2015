package com.adventofcode.day12;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Day12 {
    private final JsonFactory factory = new JsonFactory();

    public int calculateSum(final Path filepath) {
        try (JsonParser parser = factory.createParser(new File(filepath.toUri()))) {
            int sum = 0;
            while (parser.nextToken() != null) {
                if (parser.getCurrentToken() == JsonToken.VALUE_NUMBER_INT) {
                    sum += parser.getIntValue();
                }
            }
            return sum;
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

}
