package pl.net.kopczynski.routes;

import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.model.RouteDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.net.kopczynski.processors.HeadersFilterProcessor;

import java.util.concurrent.ConcurrentHashMap;

import static pl.net.kopczynski.utils.RouteUtils.getHeader;

/**
 * Created by tkopczynski on 11/09/16.
 */
@Component
public class StoragePutRoute extends BaseRouteBuilder {

    @Autowired
    private ConcurrentHashMap<String, String> storage;

    public StoragePutRoute(final HeadersFilterProcessor headersFilterProcessor) {
        super(headersFilterProcessor);
    }

    @Override
    protected ProcessorDefinition<RouteDefinition> prepareRoute() {
        rest().put("/storage/{key}/{value}").to("direct:storageSave");
        return from("direct:storageSave").process(exchange -> storage.put(getHeader(exchange, "key"), getHeader(exchange, "value")));
    }
}
