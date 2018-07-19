package wisoft.io.spring.functionapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;


@SpringBootApplication
public class WebFluxServer {
    public static void main(String[] args) {
        SpringApplication.run(WebFluxServer.class, args);
    }
}
