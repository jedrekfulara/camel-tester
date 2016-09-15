package pl.net.kopczynski.routes;

import org.apache.camel.model.RecipientListDefinition;
import org.springframework.stereotype.Component;
import pl.net.kopczynski.processors.HeadersFilterProcessor;

@Component
public class ProxyRoute extends BaseRouteBuilder {

    public ProxyRoute(final HeadersFilterProcessor headersFilterProcessor) {
        super(headersFilterProcessor);
    }

    @Override
    protected RecipientListDefinition prepareRoute() {
        rest().get("/proxy").to("direct:proxy");

        return from("direct:proxy").recipientList(simple("http://localhost:8080/api/hello?bridgeEndpoint=true"));
    }
}
