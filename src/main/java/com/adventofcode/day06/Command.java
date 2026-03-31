package com.adventofcode.day06;

public enum Command {
    TURN_ON("turn on"),
    TURN_OFF("turn off"),
    TOGGLE("toggle");

    private final String label;

    Command(final String label) {
        this.label = label;
    }

    public Light apply(final Light light) {
        return switch (this) {
            case TURN_ON -> new Light(true, light.brightness() + 1);
            case TURN_OFF -> new Light(false, Math.max(light.brightness() - 1, 0));
            case TOGGLE -> new Light(!light.state(), light.brightness() + 2);
        };
    }

    public static Command fromString(final String input) {
        for (Command command : values()) {
            if (command.label.equals(input)) {
                return command;
            }
        }
        throw new IllegalArgumentException("Unknown command: " + input);
    }

}
