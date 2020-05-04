package de.kartax.ocptestbackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetingControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void simpleGreeting() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/"+GreetingController.PATH_SIMPLE_GREETING, String.class))
                .contains(GreetingController.SIMPLE_RESPONSE);
    }
}
