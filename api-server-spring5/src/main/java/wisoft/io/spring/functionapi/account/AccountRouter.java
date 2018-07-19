package wisoft.io.spring.functionapi.account;

import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

public class AccountRouter {

    public RouterFunction<ServerResponse> routingFunction() {
        AccountRepository repository = new AccountRepositoryImp();
        AccountHandler handler = new AccountHandler(repository);

        return nest(
                path("/getAccounts"),
                nest(
                        accept(APPLICATION_JSON),
                        route(
                                GET("/{id}"),
                                handler::getAccount
                        ).andRoute(
                                method(HttpMethod.GET),
                                handler::getAccounts
                        )
                ).andRoute(
                        POST("/").and(contentType(APPLICATION_JSON)),
                        handler::registerAccount
                )
        );
    }
}
