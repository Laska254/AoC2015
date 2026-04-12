package com.adventofcode.day14;

import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class ReindeerParser {

    private static final Pattern LINE_PATTERN = Pattern.compile(
            "(?<name>\\w+) can fly (?<speed>\\d+) km/s for (?<sprint>\\d+) seconds, " +
                    "but then must rest for (?<rest>\\d+) seconds\\."
    );

    private ReindeerParser() {
    }

    public static Set<Reindeer> parseAll(final List<String> lines) {
        return lines.stream()
                .map(ReindeerParser::parse)
                .collect(Collectors.toSet());
    }

    private static Reindeer parse(final String line) {
        final var matcher = LINE_PATTERN.matcher(line.trim());
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Cannot parse line: " + line);
        }
        return new Reindeer(
                matcher.group("name"),
                Integer.parseInt(matcher.group("speed")),
                Integer.parseInt(matcher.group("sprint")),
                Integer.parseInt(matcher.group("rest"))
        );
    }

}
