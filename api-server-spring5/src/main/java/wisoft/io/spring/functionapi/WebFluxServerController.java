package wisoft.io.spring.functionapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
public class WebFluxServerController {

    @GetMapping("/")
    Mono<String> index(){
        return Mono.just("Hello Spring 5 | Root pages");
    }

}
