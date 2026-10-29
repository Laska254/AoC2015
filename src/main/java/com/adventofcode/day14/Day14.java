package com.adventofcode.day14;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day14 {

    private final Set<Reindeer> reindeerSet;
    private final Set<Reindeer> leaders = new HashSet<>();

    public Day14(List<String> input) {
        reindeerSet = ReindeerParser.parseAll(input);
    }

    public void run(final int time) {
        var currentTime = 0;
        while (currentTime < time) {
            var maxDistanceForTurn = 0;
            for (Reindeer reindeer : reindeerSet) {
                reindeer.move(currentTime);
                maxDistanceForTurn = getMaxDistanceForTurn(reindeer,
                        maxDistanceForTurn);
            }
            leaders.forEach(Reindeer::addScore);
            currentTime++;
        }
    }

    private int getMaxDistanceForTurn(final Reindeer reindeer, final int maxDistanceForTurn) {
        var maxDistance = maxDistanceForTurn;
        var traveledDistance = reindeer.getTraveledDistance();
        if (traveledDistance > maxDistance) {
            maxDistance = traveledDistance;
            leaders.clear();
            leaders.add(reindeer);
        }
        if (traveledDistance == maxDistance) {
            leaders.add(reindeer);
        }
        return maxDistance;
    }

    public int getMaxDistance() {
        return reindeerSet.stream()
                .mapToInt(Reindeer::getTraveledDistance)
                .max()
                .orElse(0);
    }

    public int getMinDistance() {
        return reindeerSet.stream()
                .mapToInt(Reindeer::getTraveledDistance)
                .min()
                .orElse(0);
    }

    public int getMaxScore() {
        return reindeerSet.stream()
                .mapToInt(Reindeer::getScore)
                .max()
                .orElse(0);
    }

    public int getMinScore() {
        return reindeerSet.stream()
                .mapToInt(Reindeer::getScore)
                .min()
                .orElse(0);
    }

}
