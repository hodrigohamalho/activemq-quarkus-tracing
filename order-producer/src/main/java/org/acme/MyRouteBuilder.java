package org.acme;

import java.time.LocalTime;

import javax.ws.rs.core.MediaType;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {
    
    @Override
    public void configure() throws Exception {

        from("timer:generate?period=3000")
            .log("Creating Order")
            .bean(OrderService.class, "generateOrder")
            .log("Order ${body.item} generated")
            .log("Saving in database")
            .to(this.insertOrder)
            .to("direct:send-to-broker");

        from("direct:send-to-broker")
            .choice()
                .when(simple("${body.item} == 'Camel'"))
                    .log("Processing a camel book")
                    .marshal().json() // convert to JSON
                    .to("kafka:camel-book") // send to KAFKA topic camel-book
                    .to("amqp:queue:activemq-book") // send to ARTEMIS activemq-book
                .otherwise()
                    .log("Processing an activemq book")
                    .marshal().jacksonXml() // convert to XML
                    .to("kafka:activemq-book") // send to KAFKA topic activemq-book
                    .to("amqp:queue:activemq-book"); // send to ARTEMIS activemq-book

        rest("/say").produces(MediaType.TEXT_PLAIN)
            .get("/hello").to("direct:meuDirect");

    }

    // Query support
    private String ds = "";//"?dataSource=dataSource";
    private String insertOrder = "sql:insert into orders (item, amount, description, processed) values " +
    	                		"(:#${body.item}, :#${body.amount}, :#${body.description}, false)"+ ds;

}
