package wisoft.io.spring.functionapi.account;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

public class AccountHandler {

	private final AccountRepository repository;

	public AccountHandler(AccountRepository repository) {
		this.repository = repository;
	}

	public Mono<ServerResponse> registerAccount(ServerRequest request) {
		Mono<Account> person = request.bodyToMono(Account.class);
		return ServerResponse.ok().build(this.repository.savePerson(person));
	}

	public Mono<ServerResponse> getAccounts(ServerRequest request) {
		Flux<Account> people = this.repository.findAll();
		return ServerResponse.ok().contentType(APPLICATION_JSON).body(people, Account.class);
	}

	public Mono<ServerResponse> getAccount(ServerRequest request) {
		int personId = Integer.valueOf(request.pathVariable("id"));
		Mono<ServerResponse> notFound = ServerResponse.notFound().build();
		Mono<Account> personMono = this.repository.findByAccountId(personId);
		return personMono
				.flatMap(account -> ServerResponse.ok().contentType(APPLICATION_JSON).body(fromObject(account)))
				.switchIfEmpty(notFound);
	}
}
