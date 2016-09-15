package pl.net.kopczynski.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.model.RouteDefinition;
import pl.net.kopczynski.processors.HeadersFilterProcessor;

public abstract class BaseRouteBuilder extends RouteBuilder {

    private HeadersFilterProcessor headersFilterProcessor;

    public BaseRouteBuilder(final HeadersFilterProcessor headersFilterProcessor) {
        this.headersFilterProcessor = headersFilterProcessor;
    }

    @Override
    public void configure() throws Exception {
        final ProcessorDefinition<RouteDefinition> route = prepareRoute();
        route.process(headersFilterProcessor);
    }

    abstract protected ProcessorDefinition<RouteDefinition> prepareRoute();
}

