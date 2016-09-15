package pl.net.kopczynski.routes;

import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.model.RouteDefinition;
import org.springframework.stereotype.Component;
import pl.net.kopczynski.processors.HeadersFilterProcessor;

@Component
public class HelloNameRoute extends BaseRouteBuilder {

    public HelloNameRoute(final HeadersFilterProcessor headersFilterProcessor) {
        super(headersFilterProcessor);
    }

    @Override
    protected ProcessorDefinition<RouteDefinition> prepareRoute() {
        rest().get("/hello/{name}").to("direct:helloName");
        return from("direct:helloName").setBody().constant("Hello " + header("name"));
    }
}
