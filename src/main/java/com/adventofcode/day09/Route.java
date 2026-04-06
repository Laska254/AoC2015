package com.adventofcode.day09;

import java.util.List;

public record Route(List<String> path, int distance) {

    public static Route empty(final SearchType searchType) {
        return new Route(List.of(), searchType == SearchType.SHORTEST
                ? Integer.MAX_VALUE
                : 0);
    }

    public boolean isBetterThan(final Route other, final SearchType searchType) {
        return searchType == SearchType.SHORTEST
                ? this.distance < other.distance
                : this.distance > other.distance;
    }

    public Route withPath(final List<String> newPath) {
        return new Route(List.copyOf(newPath), this.distance);
    }

    @Override
    public String toString() {
        return String.format("path=%s, distance=%d", path, distance);
    }

}
