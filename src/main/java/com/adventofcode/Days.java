package com.adventofcode;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public final class Days {

    public static Optional<Solution> solution(final int day) {
        final Class<?> type;
        try {
            type = Class.forName("com.adventofcode.day%1$02d.Day%1$02d".formatted(day));
        } catch (final ClassNotFoundException exception) {
            return Optional.empty();
        }
        if (!Solution.class.isAssignableFrom(type)) {
            return Optional.empty();
        }
        try {
            return Optional.of(type.asSubclass(Solution.class).getDeclaredConstructor().newInstance());
        } catch (final InvocationTargetException exception) {
            throw new IllegalStateException(type.getName() + " failed to construct", exception.getCause());
        } catch (final ReflectiveOperationException exception) {
            throw new IllegalStateException(type.getName() + " needs a public no-arg constructor", exception);
        }
    }

    public static Optional<String> input(final int day) {
        try (final var stream = Days.class.getClassLoader().getResourceAsStream(inputPath(day))) {
            if (stream == null) {
                return Optional.empty();
            }
            return Optional.of(new String(stream.readAllBytes(), StandardCharsets.UTF_8).stripTrailing());
        } catch (final IOException exception) {
            throw new UncheckedIOException("Failed to read " + inputPath(day), exception);
        }
    }

    public static String inputPath(final int day) {
        return "inputs/day%02d.txt".formatted(day);
    }

}
