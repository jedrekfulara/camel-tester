package pl.net.kopczynski.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class HeadersFilterProcessor implements Processor{
    @Override
    public void process(final Exchange exchange) throws Exception {
        if (exchange.getIn().getHeader("name") != null) {
            exchange.getIn().removeHeader("name");
        }
    }
}
