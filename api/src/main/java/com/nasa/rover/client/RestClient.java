package com.nasa.rover.client;

import com.nasa.rover.model.Rover;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClient {
    private Client client = ClientBuilder.newClient();
    private String baseUrl;

    public RestClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Response getRover() {
        return client
                .target(baseUrl + "/rover")
                .request(MediaType.APPLICATION_JSON)
                .get();
    }

    public Response postCommandSequence(String commandSequence) {
        return client
                .target(baseUrl + "/rover/command/sequence")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(commandSequence, MediaType.TEXT_PLAIN));
    }

    public Response postCommand(String command) {
        return client
                .target(baseUrl + "/rover/command")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(command, MediaType.TEXT_PLAIN));
    }

    public Response postReset() {
        return client
                .target(baseUrl + "/rover/reset")
                .request()
                .post(null);
    }
}
