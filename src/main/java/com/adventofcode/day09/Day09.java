package com.adventofcode.day09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day09 {
    private static final String SEPARATOR = "\\s*(to|=)\\s*";
    private final Map<String, HashMap<String, Integer>> graph = new HashMap<>();
    private List<String> cities;
    private List<String> resultRoute = new ArrayList<>();
    private int resultDistance = 0;

    public int getResultDistance(final List<String> inputList, final SearchType searchType) {
        inputList.forEach(line -> {
            final var split = line.split(SEPARATOR);
            graph.computeIfAbsent(split[0], k -> new HashMap<>())
                    .put(split[1], Integer.parseInt(split[2]));
            graph.computeIfAbsent(split[1], k -> new HashMap<>())
                    .put(split[0], Integer.parseInt(split[2]));
        });
        this.cities = new ArrayList<>(graph.keySet());
        if (searchType.equals(SearchType.SHORTEST)) {
            resultDistance = Integer.MAX_VALUE;
        }
        for (String city : cities) {
            final var path = new ArrayList<String>();
            final var visited = new HashSet<String>();
            path.add(city);
            visited.add(city);
            findRoute(path, visited, 0, searchType);
        }
        return resultDistance;
    }

    private void findRoute(final List<String> path,
                           final Set<String> visited,
                           final int distance,
                           final SearchType searchType) {
        if (path.size() == cities.size()) {
            if (searchType.equals(SearchType.SHORTEST) && distance < resultDistance ||
                    searchType.equals(SearchType.LONGEST) && distance > resultDistance) {
                resultDistance = distance;
                resultRoute = new ArrayList<>(path);
            }
            return;
        }
        final var city = path.getLast();
        final var neighbors = graph.get(city);
        if (neighbors == null) {
            return;
        }
        for (String neighbor : neighbors.keySet()) {
            if (!visited.contains(neighbor)) {
                path.add(neighbor);
                visited.add(neighbor);
                findRoute(path, visited, distance + neighbors.get(neighbor), searchType);
                path.removeLast();
                visited.remove(neighbor);
            }
        }
    }

    public String getResultRoute(final SearchType searchType) {
        return searchType.equals(SearchType.SHORTEST)
                ? String.format("Shortest route = %s, shortestDistance = %d", resultRoute, resultDistance)
                : String.format("Longest route = %s, longestDistance = %d", resultRoute, resultDistance
        );
    }

}
