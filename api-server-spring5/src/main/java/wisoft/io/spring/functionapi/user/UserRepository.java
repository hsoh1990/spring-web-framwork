package wisoft.io.spring.functionapi.user;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private final Map<Integer, User> people = new HashMap<>();

    public UserRepository() {
        this.people.put(1, new User("hsoh", 29));
        this.people.put(2, new User("mj", 28));
    }

    public Mono<User> findByUserId(int id) {
        return Mono.justOrEmpty(this.people.get(id));
    }

    public Flux<User> findAll() {
        return Flux.fromIterable(this.people.values());
    }

    public Mono<Void> saveUser(Mono<User> personMono) {
        return personMono.doOnNext(account -> {
            int id = people.size() + 1;
            people.put(id, account);
            System.out.format("Saved %s with id %d%n", account, id);
        }).thenEmpty(Mono.empty());
    }
}
