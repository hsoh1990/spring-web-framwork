package wisoft.io.spring.functionapi;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.reactive.server.WebTestClient;

public class WebFluxServerTests {

    private WebTestClient testClient;

    @Before
    public void createTestClient() {
        Server server = new Server();
        this.testClient = WebTestClient.bindToServer()
                .baseUrl("http://localhost:8080/")
                .build();
    }

    @Test
    public void getRoot() throws Exception {
        String body = "Hello Spring 5 | Root pages";

        this.testClient.get()
                .uri("/")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType("text/plain;charset=UTF-8")
                .expectBody(String.class)
                .isEqualTo(body);
    }
}
