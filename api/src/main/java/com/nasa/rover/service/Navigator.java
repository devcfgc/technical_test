package com.nasa.rover.service;

import com.nasa.rover.model.Position;
import com.nasa.rover.model.enums.CardinalPoint;
import com.nasa.rover.util.CircularArrayList;

public class Navigator implements INavigator {
    private CircularArrayList<CardinalPoint> orientationList;

    public Navigator() {
        orientationList = new CircularArrayList<>();
        orientationList.add(CardinalPoint.NORTH);
        orientationList.add(CardinalPoint.EAST);
        orientationList.add(CardinalPoint.SOUTH);
        orientationList.add(CardinalPoint.WEST);
    }

    public CardinalPoint rotateLeft(CardinalPoint currentOrientation) {
        return orientationList.getPrevious(orientationList.indexOf(currentOrientation));
    }

    public CardinalPoint rotateRight(CardinalPoint currentOrientation) {
        return orientationList.getNext(orientationList.indexOf(currentOrientation));
    }

    public void moveForward(Position currentPosition, CardinalPoint currentOrientation) {
        switch (currentOrientation) {
            case NORTH: currentPosition.increaseY(); break;
            case EAST: currentPosition.increaseX(); break;
            case SOUTH: currentPosition.decreaseY(); break;
            case WEST: currentPosition.decreaseX(); break;
        }
    }

    public void moveBackward(Position currentPosition, CardinalPoint currentOrientation) {
        switch (currentOrientation) {
            case NORTH: currentPosition.decreaseY(); break;
            case EAST: currentPosition.decreaseX(); break;
            case SOUTH: currentPosition.increaseY(); break;
            case WEST: currentPosition.increaseX(); break;
        }
    }
}
