package org.acme;

import javax.ws.rs.core.MediaType;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

    
    @Override
    public void configure() throws Exception {


        from("timer:MeuTimer?period=5000")
            .setBody(simple("Corpo da mensagem"))
            .to("direct:meuDirect")
            ;

        rest("/say").produces(MediaType.TEXT_PLAIN)
            .get("/hello").to("direct:meuDirect")
            ;

        from("direct:meuDirect")
            .setBody(simple("Ola"))
            .log("Mensagem: ${body}")
            .to("amqp:queue:fila1")
            ;
    }

}
