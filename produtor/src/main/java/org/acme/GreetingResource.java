package org.acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.camel.component.amqp.AMQPConnectionDetails;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class GreetingResource {

    @Inject
    @ConfigProperty(name = "amqp-port")
    String port;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive "+port;
    }

    @Produces
    AMQPConnectionDetails amqpConnection() {
        return new AMQPConnectionDetails("amqp://localhost:" + port);
    }
}