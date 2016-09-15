package pl.net.kopczynski.utils;

import org.apache.camel.Exchange;

public final class RouteUtils {

    public static String getHeader(Exchange exchange, String name) {
        return exchange.getIn().getHeader(name).toString();
    }
}
