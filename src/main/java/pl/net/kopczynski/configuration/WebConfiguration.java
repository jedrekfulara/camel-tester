package pl.net.kopczynski.configuration;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by tkopczynski on 10/09/16.
 */
@Configuration
public class WebConfiguration implements ServletContextInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic camelServlet = servletContext.addServlet("CamelServlet", new CamelHttpTransportServlet());

        camelServlet.addMapping("/api/*");
        camelServlet.setAsyncSupported(true);
        camelServlet.setLoadOnStartup(1);

    }
}
