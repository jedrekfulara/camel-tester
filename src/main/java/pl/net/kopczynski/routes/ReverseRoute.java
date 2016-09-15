package pl.net.kopczynski.routes;

import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.model.RouteDefinition;
import org.springframework.stereotype.Component;
import pl.net.kopczynski.processors.HeadersFilterProcessor;
import pl.net.kopczynski.utils.RouteUtils;

@Component
public class ReverseRoute extends BaseRouteBuilder {

    public ReverseRoute(final HeadersFilterProcessor headersFilterProcessor) {
        super(headersFilterProcessor);
    }

    @Override
    protected ProcessorDefinition<RouteDefinition> prepareRoute() {
        rest().get("/rev/{param}").to("direct:reverse");
        return from("direct:reverse").process(exchange -> exchange.getIn().setBody(new StringBuilder(RouteUtils.getHeader(exchange, "param")).reverse().toString()));
    }
}
