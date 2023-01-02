package org.acme;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("kafka:topic1?")
            .log("Recebendo mensagem: ${body}")
            .to("amqp:queue:fila2")
            ;
    }
    
}
