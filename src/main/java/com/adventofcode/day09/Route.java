package com.adventofcode.day09;

import java.util.List;

public record Route(List<String> path, int distance) {

    public static Route empty(final SearchType searchType) {
        return new Route(List.of(), searchType.getInitDistance());
    }

    public Route compete(final List<String> path, final int distance, final SearchType searchType) {
        return searchType.isBetter(distance, this.distance)
                ? new Route(List.copyOf(path), distance)
                : this;
    }

    @Override
    public String toString() {
        return String.format("path=%s, distance=%d", path, distance);
    }

}
