package com.adventofcode.day09;

import java.util.List;

public record Route(List<String> path, int distance) {

    public static Route empty(final SearchType searchType) {
        return new Route(List.of(), searchType.getInitDistance());
    }

    public Route compete(final List<String> path, final int distance, final SearchType searchType) {
        final var candidate = new Route(path, distance);
        return candidate.isBetterThan(this, searchType)
                ? candidate.withPath(path)
                : this;
    }

    public boolean isBetterThan(final Route other, final SearchType searchType) {
        return searchType.isBetter(this.distance, other.distance);
    }

    public Route withPath(final List<String> newPath) {
        return new Route(List.copyOf(newPath), this.distance);
    }

    @Override
    public String toString() {
        return String.format("path=%s, distance=%d", path, distance);
    }

}
