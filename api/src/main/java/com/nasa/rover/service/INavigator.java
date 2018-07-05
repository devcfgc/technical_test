package com.nasa.rover.service;

import com.nasa.rover.model.Position;
import com.nasa.rover.model.enums.CardinalPoint;

public interface INavigator {
    CardinalPoint rotateLeft(CardinalPoint currentOrientation);
    CardinalPoint rotateRight(CardinalPoint currentOrientation);
    void moveForward(Position currentPosition, CardinalPoint currentOrientation);
    void moveBackward(Position currentPosition, CardinalPoint currentOrientation);
}
