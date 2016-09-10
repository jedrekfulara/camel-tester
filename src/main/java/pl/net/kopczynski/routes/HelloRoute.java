package pl.net.kopczynski.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by tkopczynski on 10/09/16.
 */
@Component
public class HelloRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        rest().get("/hello").to("direct:hello");

        from("direct:hello").setBody().constant("Hello world");
    }
}
