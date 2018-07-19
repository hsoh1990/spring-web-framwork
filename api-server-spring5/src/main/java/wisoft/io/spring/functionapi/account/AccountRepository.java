package wisoft.io.spring.functionapi.account;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountRepository {

    Mono<Account> findByAccountId(int id);

    Flux<Account> findAll();

    Mono<Void> savePerson(Mono<Account> person);

}
