package com.adventofcode.day06;

public enum Command {
    TURN_ON,
    TURN_OFF,
    TOGGLE;

    public Light apply(final Light light) {
        return switch (this) {
            case TURN_ON -> new Light(true, light.brightness() + 1);
            case TURN_OFF -> new Light(false, Math.max(light.brightness() - 1, 0));
            case TOGGLE -> new Light(!light.state(), light.brightness() + 2);
        };
    }

    public static Command fromString(String command) {
        return switch (command) {
            case "turn on" -> TURN_ON;
            case "turn off" -> TURN_OFF;
            case "toggle" -> TOGGLE;
            default -> throw new IllegalArgumentException("Unknown command: " + command);
        };
    }

}
