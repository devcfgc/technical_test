package com.nasa.rover.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nasa.rover.service.INavigator;
import com.nasa.rover.model.enums.CardinalPoint;
import com.nasa.rover.model.enums.Movement;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rover {
    private Position position;
    private CardinalPoint orientation;
    private INavigator navigator;

    public Rover() {
    }

    public Rover(Position position, CardinalPoint orientation, INavigator navigator) {
        this.position = position;
        this.orientation = orientation;
        this.navigator = navigator;
    }

    public void move(String movements) {
        movements.chars().forEach(movement ->
        {
            if (movement == Movement.BACKWARD.getValue()) {
                navigator.moveBackward(position, orientation);
            } else if (movement == Movement.FORWARD.getValue()) {
                navigator.moveForward(position, orientation);
            } else if (movement == Movement.LEFT.getValue()) {
                orientation = navigator.rotateLeft(orientation);
            } else if (movement == Movement.RIGHT.getValue()) {
                orientation = navigator.rotateRight(orientation);
            }
        });
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Rover actual = (Rover) obj;

        return position.equals(actual.position)
                && orientation.equals(actual.orientation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, orientation);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public CardinalPoint getOrientation() {
        return orientation;
    }

    public void setOrientation(CardinalPoint orientation) {
        this.orientation = orientation;
    }
}
