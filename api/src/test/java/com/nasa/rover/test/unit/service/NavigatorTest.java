package com.nasa.rover.test.unit.service;

import com.nasa.rover.service.Navigator;
import com.nasa.rover.model.Position;
import com.nasa.rover.model.enums.CardinalPoint;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NavigatorTest {
    private Navigator navigator = new Navigator();

    @Test
    public void rotateLeftShouldReturnExpectedOrientation() {
        assertEquals(CardinalPoint.WEST, navigator.rotateLeft(CardinalPoint.NORTH));
        assertEquals(CardinalPoint.NORTH, navigator.rotateLeft(CardinalPoint.EAST));
        assertEquals(CardinalPoint.EAST, navigator.rotateLeft(CardinalPoint.SOUTH));
        assertEquals(CardinalPoint.SOUTH, navigator.rotateLeft(CardinalPoint.WEST));
    }

    @Test
    public void rotateRightShouldReturnExpectedOrientation() {
        assertEquals(CardinalPoint.EAST, navigator.rotateRight(CardinalPoint.NORTH));
        assertEquals(CardinalPoint.SOUTH, navigator.rotateRight(CardinalPoint.EAST));
        assertEquals(CardinalPoint.WEST, navigator.rotateRight(CardinalPoint.SOUTH));
        assertEquals(CardinalPoint.NORTH, navigator.rotateRight(CardinalPoint.WEST));
    }

    @Test
    public void moveForwardShouldReturnExpectedPositionWhenOrientationNorth() {
        Position position = new Position(3, 8);

        navigator.moveForward(position, CardinalPoint.NORTH);
        assertEquals(new Position(3, 9), position);
    }

    @Test
    public void moveForwardShouldReturnExpectedPositionWhenOrientationEast() {
        Position position = new Position(3, 8);

        navigator.moveForward(position, CardinalPoint.EAST);
        assertEquals(new Position(4, 8), position);
    }

    @Test
    public void moveForwardShouldReturnExpectedPositionWhenOrientationSouth() {
        Position position = new Position(3, 8);

        navigator.moveForward(position, CardinalPoint.SOUTH);
        assertEquals(new Position(3, 7), position);
    }

    @Test
    public void moveForwardShouldReturnExpectedPositionWhenOrientationWest() {
        Position position = new Position(3, 8);

        navigator.moveForward(position, CardinalPoint.WEST);
        assertEquals(new Position(2, 8), position);
    }

    @Test
    public void moveBackwardShouldReturnExpectedPositionWhenOrientationNorth() {
        Position position = new Position(3, 8);

        navigator.moveBackward(position, CardinalPoint.NORTH);
        assertEquals(new Position(3, 7), position);
    }

    @Test
    public void moveBackwardShouldReturnExpectedPositionWhenOrientationEast() {
        Position position = new Position(3, 8);

        navigator.moveBackward(position, CardinalPoint.EAST);
        assertEquals(new Position(2, 8), position);
    }

    @Test
    public void moveBackwardShouldReturnExpectedPositionWhenOrientationSouth() {
        Position position = new Position(3, 8);

        navigator.moveBackward(position, CardinalPoint.SOUTH);
        assertEquals(new Position(3, 9), position);
    }

    @Test
    public void moveBackwardShouldReturnExpectedPositionWhenOrientationWest() {
        Position position = new Position(3, 8);

        navigator.moveBackward(position, CardinalPoint.WEST);
        assertEquals(new Position(4, 8), position);
    }
}
