package wisoft.io.spring.functionapi.account;

import org.junit.Before;
import org.junit.Test;

import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.HashMap;
import java.util.Map;

public class AccountTest {

    private WebTestClient testClient;

    @Before
    public void createTestClient() {
        AccountRouter accountRouter = new AccountRouter();
        this.testClient = WebTestClient.bindToRouterFunction(accountRouter.routingFunction())
                .configureClient()
                .baseUrl("http://localhost/")
                .build();
    }

    @Test
    public void postAccount() throws Exception {
        Account khyoun = new Account("khyoun", 29);

        this.testClient.post()
                .uri("/getAccounts")
                .contentType(MediaType.APPLICATION_JSON)
                .syncBody(khyoun)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void getAccount() {
        this.testClient.get()
                .uri("/getAccounts")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Account.class).hasSize(2).returnResult();
    }

    @Test
    public void getAccountById() {
        this.testClient.get()
                .uri("/getAccounts/1")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Account.class).hasSize(1).returnResult();
    }

    @Test
    public void getAccountByIdNotFound() {
        this.testClient.get()
                .uri("/getAccounts/100")
                .exchange()
                .expectStatus().isNotFound();
    }
}