package wisoft.io.spring.functionapi.user;

import org.junit.Before;
import org.junit.Test;

import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import wisoft.io.spring.functionapi.Server;


public class UserTest {

    private WebTestClient testClient;

    @Before
    public void createTestClient() {
        Server server = new Server();
        this.testClient = WebTestClient.bindToServer()
                .baseUrl("http://localhost:8080/")
                .build();
    }

    @Test
    public void postUser() throws Exception {
        User khyoun = new User("khyoun", 29);

        this.testClient.post()
                .uri("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .syncBody(khyoun)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void getUsers() {
        this.testClient.get()
                .uri("/users")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType("application/json;charset=UTF-8")
                .expectBodyList(User.class).hasSize(3).returnResult();
    }

    @Test
    public void getUser() {
        this.testClient.get()
                .uri("/users/1")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType("application/json;charset=UTF-8")
                .expectBodyList(User.class).hasSize(1).returnResult();
    }
}