package com.adventofcode.day09;

import java.util.List;

public class Day09 {

    private static final String SEPARATOR = "\\s*(to|=)\\s*";

    public Route getResultDistance(final List<String> inputList, final SearchType searchType) {
        final var graph = new Graph();
        inputList.forEach(line -> {
            final var split = line.split(SEPARATOR);
            graph.addEdge(split[0], split[1], Integer.parseInt(split[2]));
        });
        return graph.findBestRoute(searchType);
    }

}
