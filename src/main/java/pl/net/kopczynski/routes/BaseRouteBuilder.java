package pl.net.kopczynski.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.ProcessorDefinition;
import pl.net.kopczynski.processors.HeadersFilterProcessor;

public abstract class BaseRouteBuilder<T extends ProcessorDefinition> extends RouteBuilder {

    private HeadersFilterProcessor headersFilterProcessor;

    public BaseRouteBuilder(final HeadersFilterProcessor headersFilterProcessor) {
        this.headersFilterProcessor = headersFilterProcessor;
    }

    @Override
    public void configure() throws Exception {
        final T route = prepareRoute();
        route.process(headersFilterProcessor);
    }

    abstract protected T prepareRoute();
}

