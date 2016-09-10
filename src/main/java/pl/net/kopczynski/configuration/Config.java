package pl.net.kopczynski.configuration;

import org.apache.camel.CamelContext;
import org.apache.camel.spi.RestConfiguration;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tkopczynski on 10/09/16.
 */
@Configuration
public class Config {

    @Bean
    public CamelContextConfiguration contextConfiguration() {
        return new CamelContextConfiguration() {
            @Override
            public void beforeApplicationStart(CamelContext context) {
                RestConfiguration restConfiguration = new RestConfiguration();
                restConfiguration.setComponent("servlet");

                context.setRestConfiguration(restConfiguration);
            }

            @Override
            public void afterApplicationStart(CamelContext camelContext) {

            }
        };
    }

}
