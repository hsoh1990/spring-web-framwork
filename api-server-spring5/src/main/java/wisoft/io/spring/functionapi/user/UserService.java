package wisoft.io.spring.functionapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Mono<Void> registerUser(Mono<User> userMono) {
        return userRepository.saveUser(userMono);
    }

    public Flux<User> getUsers() {
        return userRepository.findAll();
    }

    public Mono<User> getUser(int id) {
        return userRepository.findByUserId(id);
    }

}
