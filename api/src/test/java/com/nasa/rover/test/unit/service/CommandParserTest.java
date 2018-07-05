package com.nasa.rover.test.unit.service;

import com.nasa.rover.service.CommandParser;
import com.nasa.rover.service.INavigator;
import com.nasa.rover.service.Navigator;
import com.nasa.rover.model.Position;
import com.nasa.rover.model.Rover;
import com.nasa.rover.model.enums.CardinalPoint;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class CommandParserTest {
    @Mock
    private INavigator navigator;
    private CommandParser commandParser;

    @Before
    public void init() {
        commandParser = new CommandParser(navigator);
    }

    @Test
    public void parseShouldReturnRoverInstanceWhenValidPositionOrientationMovement() {
        String command = "21NFFRBRFFLF";
        Rover expectedRover = new Rover(new Position(2, 1), CardinalPoint.NORTH, new Navigator());

        Rover result = commandParser.parse(command);

        assertEquals(expectedRover, result);
    }

    @Test
    public void parseShouldReturnRoverInstanceWhenLowercase() {
        String command = "21nFFRbRFFlF";
        Rover expectedRover = new Rover(new Position(2, 1), CardinalPoint.NORTH, new Navigator());

        Rover result = commandParser.parse(command);

        assertEquals(expectedRover, result);
    }

    @Test
    public void parseShouldReturnRoverInstanceWhenNoMovement() {
        String command = "21N";
        Rover expectedRover = new Rover(new Position(2, 1), CardinalPoint.NORTH, new Navigator());

        Rover result = commandParser.parse(command);

        assertEquals(expectedRover, result);
    }

    @Test
    public void parseShouldReturnNullWhenXPositionNotValid() {
        String command = "X1NFFRBRFFLF";

        Rover result = commandParser.parse(command);

        assertNull(result);
    }

    @Test
    public void parseShouldReturnNullWhenYPositionNotValid() {
        String command = "2YNFFRBRFFLF";

        Rover result = commandParser.parse(command);

        assertNull(result);
    }

    @Test
    public void parseShouldReturnNullWhenOrientationNotValid() {
        String command = "21XFFRBRFFLF";

        Rover result = commandParser.parse(command);

        assertNull(result);
    }
}
