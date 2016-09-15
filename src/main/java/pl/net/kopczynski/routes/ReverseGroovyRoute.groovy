package pl.net.kopczynski.routes

import org.apache.camel.model.ProcessorDefinition
import org.apache.camel.model.RouteDefinition
import org.springframework.stereotype.Component
import pl.net.kopczynski.processors.HeadersFilterProcessor

@Component
class ReverseGroovyRoute extends BaseRouteBuilder {


    ReverseGroovyRoute(final HeadersFilterProcessor headersFilterProcessor) {
        super(headersFilterProcessor)
    }

    @Override
    protected ProcessorDefinition<RouteDefinition> prepareRoute() {
        rest().get("/revGroovy/{param}").to("direct:reverseGroovy");
        from("direct:reverseGroovy").process { it.in.setBody(it.in.getHeader("param", String.class).reverse()) }
    }
}
