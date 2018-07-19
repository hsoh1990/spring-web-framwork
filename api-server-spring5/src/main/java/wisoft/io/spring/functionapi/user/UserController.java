package wisoft.io.spring.functionapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sun.invoke.empty.Empty;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping(value = "")
    Mono<Void> registerUser(@RequestBody User user){
        Mono<User> userMono = Mono.just(user);
        return userService.registerUser(userMono);
    }

    @GetMapping("")
    Flux<User>getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    Mono<User> getUser(@PathVariable int id) {
        return userService.getUser(id);
    }


}
