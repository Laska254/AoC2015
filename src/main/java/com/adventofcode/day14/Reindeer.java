package com.adventofcode.day14;

public class Reindeer {
    
    private final String name;
    private final int speed;
    private final int sprintTime;
    private final int restTime;
    private int score;
    private int traveledDistance;

    public Reindeer(final String name, final int speed, final int sprintTime, final int restTime) {
        this.name = name;
        this.speed = speed;
        this.sprintTime = sprintTime;
        this.restTime = restTime;
    }

    public int getTraveledDistance() {
        return traveledDistance;
    }

    public void move(final int time) {
        if (check(time)) {
            traveledDistance += speed;
        }
    }

    private boolean check(final int time) {
        final var cycle = sprintTime + restTime;
        return (time % (cycle) < sprintTime) || (time % (cycle) == 0);
    }

    public void addScore() {
        score++;
    }

    public int getScore() {
        return score;
    }

}
