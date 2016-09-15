package pl.net.kopczynski.routes;

import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.model.RouteDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.net.kopczynski.processors.HeadersFilterProcessor;

import java.util.concurrent.ConcurrentHashMap;

import static pl.net.kopczynski.utils.RouteUtils.getHeader;

@Component
public class StorageGetRoute extends BaseRouteBuilder {

    @Autowired
    private ConcurrentHashMap<String, String> storage;


    @Autowired
    public StorageGetRoute(final HeadersFilterProcessor headersFilterProcessor) {
        super(headersFilterProcessor);
    }

    @Override
    protected ProcessorDefinition<RouteDefinition> prepareRoute() {
        rest().get("/storage/{key}").to("direct:storageGet");
        return from("direct:storageGet").process(exchange -> exchange.getIn().setBody(storage.get(getHeader(exchange, "key"))));
    }
}
