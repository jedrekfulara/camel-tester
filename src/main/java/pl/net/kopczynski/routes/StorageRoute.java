package pl.net.kopczynski.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by tkopczynski on 11/09/16.
 */
@Component
public class StorageRoute extends RouteBuilder {

    @Autowired
    private ConcurrentHashMap<String, String> storage;

    @Override
    public void configure() throws Exception {
        rest().put("/storage/{key}/{value}").to("direct:storageSave");
        rest().get("/storage/{key}").to("direct:storageGet");

        from("direct:storageSave").process(exchange -> storage.put(exchange.getIn().getHeader("key").toString(), exchange.getIn().getHeader("value").toString()));
        from("direct:storageGet").process(exchange -> exchange.getIn().setBody(storage.get(exchange.getIn().getHeader("key").toString())));
    }
}
