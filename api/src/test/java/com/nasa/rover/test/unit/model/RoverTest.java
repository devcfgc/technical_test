package com.nasa.rover.test.unit.model;

import com.nasa.rover.service.INavigator;
import com.nasa.rover.model.Position;
import com.nasa.rover.model.Rover;
import com.nasa.rover.model.enums.CardinalPoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RoverTest {
    @Mock
    private INavigator navigator;

    @Test
    public void moveShouldCallNavigator() {
        String movements = "FLBRFLBL";

        new Rover(new Position(0, 0), CardinalPoint.NORTH, navigator).move(movements);

        verify(navigator, times(2)).moveForward(any(), any());
        verify(navigator, times(2)).moveBackward(any(), any());
        verify(navigator, times(3)).rotateLeft(any());
        verify(navigator, times(1)).rotateRight(any());
    }

    @Test
    public void moveShouldNotCallNavigatorWhenNoMovement() {
        String movements = "";

        new Rover(new Position(0, 0), CardinalPoint.NORTH, navigator).move(movements);

        verify(navigator, never()).moveForward(any(), any());
        verify(navigator, never()).moveBackward(any(), any());
        verify(navigator, never()).rotateLeft(any());
        verify(navigator, never()).rotateRight(any());
    }
}
