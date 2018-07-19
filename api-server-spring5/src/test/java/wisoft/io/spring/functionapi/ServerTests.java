package wisoft.io.spring.functionapi;

import org.junit.Before;
import org.junit.Test;

import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

public class ServerTests {

    private WebTestClient testClient;

    @Before
    public void createTestClient() {
        Server server = new Server();
        this.testClient = WebTestClient.bindToRouterFunction(ApiRouter.getInstance().getRoute())
                .configureClient()
                .baseUrl("http://localhost/")
                .build();
    }

    @Test
    public void getRoot() throws Exception {
        String body = "Hello Spring 5 | Root page";

        this.testClient.get()
                .uri("/")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.TEXT_PLAIN)
                .expectBody(String.class)
                .isEqualTo(body);
    }
}
