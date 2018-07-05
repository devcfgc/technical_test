package com.nasa.rover.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum CardinalPoint {
    NORTH('N'),
    SOUTH('S'),
    EAST('E'),
    WEST('W');

    private char value;

    CardinalPoint(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public static CardinalPoint getName(char value) {
        for (CardinalPoint cardinalPoint : CardinalPoint.values())
            if (cardinalPoint.value == value)
                return cardinalPoint;

        return null;
    }

    public static List<Character> getValues() {
        return Arrays.stream(CardinalPoint.values())
                .map(CardinalPoint::getValue)
                .collect(Collectors.toList());
    }
}
