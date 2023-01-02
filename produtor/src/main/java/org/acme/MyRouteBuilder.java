package org.acme;

import javax.ws.rs.core.MediaType;

import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.jboss.resteasy.reactive.server.spi.ContentType;

public class MyRouteBuilder extends RouteBuilder {

    
    @Override
    public void configure() throws Exception {


        from("timer:MeuTimer?period=2000")
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
