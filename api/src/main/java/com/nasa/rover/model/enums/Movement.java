package com.nasa.rover.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Movement {
    FORWARD('F'),
    BACKWARD('B'),
    LEFT('L'),
    RIGHT('R');

    private char value;

    Movement(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public static Movement getName(char value) {
        for (Movement movement : Movement.values())
            if (movement.value == value)
                return movement;

        return null;
    }

    public static List<Character> getValues() {
        return Arrays.stream(Movement.values())
                .map(Movement::getValue)
                .collect(Collectors.toList());
    }
}
