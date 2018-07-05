package com.nasa.rover.service;

import com.nasa.rover.model.Position;
import com.nasa.rover.model.Rover;
import com.nasa.rover.model.enums.CardinalPoint;
import com.nasa.rover.model.enums.Movement;

import java.util.stream.IntStream;

public class CommandParser {
    private INavigator navigator;

    public CommandParser(INavigator navigator) {
        this.navigator = navigator;
    }

    public Rover parse(String commandSequence) {
        Rover rover = null;
        String commands = commandSequence.toUpperCase();

        if (validate(commands)) {
            rover = new Rover(getPosition(commands),
                    CardinalPoint.getName(commands.charAt(2)),
                    navigator);
        }

        return rover;
    }

    private Position getPosition(String commandSequence) {
        return new Position(Character.getNumericValue(commandSequence.charAt(0)),
                Character.getNumericValue(commandSequence.charAt(1)));
    }

    private boolean validate(String commandSequence) {
        return commandSequence.length() > 2
                && Character.isDigit(commandSequence.charAt(0))
                && Character.isDigit(commandSequence.charAt(1))
                && CardinalPoint.getValues().contains(commandSequence.charAt(2))
                && IntStream
                    .range(3, commandSequence.length())
                    .allMatch(i -> Movement.getValues().contains(commandSequence.charAt(i)));
    }
}
