package com.adventofcode.day09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {

    private final Map<String, Map<String, Integer>> graph = new HashMap<>();
    private Route bestRoute;

    public void addEdge(final String from, final String to, final int distance) {
        graph.computeIfAbsent(from, k -> new HashMap<>()).put(to, distance);
        graph.computeIfAbsent(to, k -> new HashMap<>()).put(from, distance);
    }

    public Route findBestRoute(final SearchType searchType) {
        bestRoute = Route.empty(searchType);
        graph.keySet().forEach(city -> {
            final var path = new ArrayList<String>();
            final var visited = new HashSet<String>();
            path.add(city);
            visited.add(city);
            bestRoute = findRoute(path, visited, 0, searchType, bestRoute);
        });
        return bestRoute;
    }

    private Route findRoute(final List<String> path,
                            final Set<String> visited,
                            final int distance,
                            final SearchType searchType,
                            final Route bestRoute) {
        var newBestRoute = bestRoute;
        if (path.size() == graph.size()) {
            return newBestRoute.compete(path, distance, searchType);
        }
        final var neighbors = graph.get(path.getLast());
        if (neighbors == null) {
            return newBestRoute;
        }
        for (var entry : neighbors.entrySet()) {
            if (!visited.contains(entry.getKey())) {
                path.add(entry.getKey());
                visited.add(entry.getKey());
                newBestRoute = findRoute(path, visited, distance + entry.getValue(), searchType, bestRoute);
                path.removeLast();
                visited.remove(entry.getKey());
            }
        }
        return newBestRoute;
    }

}
