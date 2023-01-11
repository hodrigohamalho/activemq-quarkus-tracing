package org.acme;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("amqp:queue:camel-book")
            .log("Message received: ${body}");

        from("amqp:queue:activemq-book")
            .log("Message received: ${body}");

    }
    
}
