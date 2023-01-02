package org.acme;

import java.time.LocalTime;

import javax.ws.rs.core.MediaType;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

    
    @Override
    public void configure() throws Exception {


        from("timer:MeuTimer?period=5000")
            .to("direct:meuDirect")
            ;

        rest("/say").produces(MediaType.TEXT_PLAIN)
            .get("/hello").to("direct:meuDirect")
            ;

        from("direct:meuDirect")
            .setBody(simple("Hello World!"))
            .log("Conteúdo da mensagem: ${body}")
            .to("kafka:topic1")
            ;
    }

}
