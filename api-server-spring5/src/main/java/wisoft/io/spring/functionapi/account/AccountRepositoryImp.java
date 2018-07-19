package wisoft.io.spring.functionapi.account;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

public class AccountRepositoryImp implements AccountRepository {

    private final Map<Integer, Account> people = new HashMap<>();

    public AccountRepositoryImp() {
        this.people.put(1, new Account("hsoh", 29));
        this.people.put(2, new Account("mj", 28));
    }

    @Override
    public Mono<Account> findByAccountId(int id) {
        return Mono.justOrEmpty(this.people.get(id));
    }

    @Override
    public Flux<Account> findAll() {
        return Flux.fromIterable(this.people.values());
    }

    @Override
    public Mono<Void> savePerson(Mono<Account> personMono) {
        return personMono.doOnNext(account -> {
            int id = people.size() + 1;
            people.put(id, account);
            System.out.format("Saved %s with id %d%n", account, id);
        }).thenEmpty(Mono.empty());
    }
}
