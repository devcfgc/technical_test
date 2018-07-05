package com.nasa.rover.test.integration;

import com.nasa.rover.client.RestClient;
import com.nasa.rover.model.Position;
import com.nasa.rover.model.Rover;
import com.nasa.rover.model.enums.CardinalPoint;
import com.nasa.rover.service.Navigator;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class IntegrationTest {
    private static RestClient client;

    @BeforeClass
    public static void loadConfig() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File("src/test/resources/config.properties")));

        String baseUrl = properties.getProperty("integrationtest.baseurl");
        client = new RestClient(baseUrl);
    }

    @Test
    public void getRoverShouldReturnExpectedRover() {
        client.postCommandSequence("11NF");
        Rover expectedRover = new Rover(new Position(1, 2), CardinalPoint.NORTH, new Navigator());
        Response response = client.getRover();

        assertEquals(200, response.getStatus());
        assertEquals(expectedRover, response.readEntity(Rover.class));
    }

    @Test
    public void getRoverShouldReturnStatusCode404WhenRoverNotInitialized() {
        client.postReset();
        Response response = client.getRover();

        assertEquals(404, response.getStatus());
    }

    @Test
    public void postCommandSequenceShouldReturnExpectedRover() {
        Response response = client.postCommandSequence("83WRFFFLFRB");
        Rover expectedRover = new Rover(new Position(7, 5), CardinalPoint.NORTH, new Navigator());

        assertEquals(200, response.getStatus());
        assertEquals(expectedRover, response.readEntity(Rover.class));
    }

    @Test
    public void postCommandSequenceShouldReturnStatusCode404WhenEmptyCommand() {
        Response response = client.postCommandSequence("");
        assertEquals(404, response.getStatus());
    }

    @Test
    public void postCommandSequenceShouldReturnStatusCode404WhenInvalidCommand() {
        Response response = client.postCommandSequence("XXX");
        assertEquals(404, response.getStatus());
    }

    @Test
    public void postCommandShouldReturnExpectedRover() {
        client.postCommandSequence("11N");
        Response response = client.postCommand("R");
        Rover expectedRover = new Rover(new Position(1, 1), CardinalPoint.EAST, new Navigator());

        assertEquals(200, response.getStatus());
        assertEquals(expectedRover, response.readEntity(Rover.class));
    }

    @Test
    public void postCommandShouldReturnStatusCode400WhenEmptyCommand() {
        client.postCommandSequence("11N");
        Response response = client.postCommand("");

        assertEquals(400, response.getStatus());
    }

    @Test
    public void postCommandShouldReturnStatusCode404WhenRoverNotInitialized() {
        client.postReset();
        Response response = client.postCommand("B");

        assertEquals(404, response.getStatus());
    }

    @Test
    public void postCommandShouldReturnStatusCode400WhenInvalidCommand() {
        client.postCommandSequence("11N");
        Response response = client.postCommand("RR");

        assertEquals(400, response.getStatus());
    }

    @Test
    public void postResetShouldReturnResetRover() {
        Response response = client.postReset();
        assertEquals(200, response.getStatus());

        response = client.getRover();
        assertEquals(404, response.getStatus());
    }
}
