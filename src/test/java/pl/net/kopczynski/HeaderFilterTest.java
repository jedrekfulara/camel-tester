package pl.net.kopczynski;

import org.apache.camel.Exchange;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CamelTesterApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HeaderFilterTest extends CamelTestSupport {

    @LocalServerPort
    private int port;

    @Test
    public void test() throws InterruptedException {
        Exchange request = createExchangeWithBody(null);
        template.send("http://localhost:" + port + "/api/hello/test", request);
        assertNull(request.getException());
        assertNull(request.getOut().getHeader("name"));
    }
}
