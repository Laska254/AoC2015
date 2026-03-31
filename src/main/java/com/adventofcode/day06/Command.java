package com.adventofcode.day06;

public enum Command {
    TURN_ON {
        @Override
        public Light apply(final Light light) {
            return new Light(true, light.brightness() + 1);
        }
    },
    TURN_OFF {
        @Override
        public Light apply(final Light light) {
            return new Light(false, Math.max(light.brightness() - 1, 0));
        }
    },
    TOGGLE {
        @Override
        public Light apply(final Light light) {
            return new Light(!light.state(), light.brightness() + 2);
        }
    };

    public abstract Light apply(final Light light);

    public static Command fromString(String command) {
        return switch (command) {
            case "turn on" -> TURN_ON;
            case "turn off" -> TURN_OFF;
            case "toggle" -> TOGGLE;
            default -> throw new IllegalArgumentException("Unknown command: " + command);
        };
    }

}
