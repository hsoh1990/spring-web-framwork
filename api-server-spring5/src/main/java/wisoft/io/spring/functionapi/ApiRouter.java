package wisoft.io.spring.functionapi;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


class ApiRouter {
    private static final String API_PATH = "/";
    private static ApiRouter instance = null;
    private RouterFunction<ServerResponse> route;

    public static ApiRouter getInstance() {
        if (instance == null) {
            instance = new ApiRouter();
        }
        return instance;
    }

    public ApiRouter() {
        this.route = nest(
                path("/"),
                nest(
                        accept(APPLICATION_JSON),
                        route(
                                method(HttpMethod.GET),
                                request -> ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).syncBody("Hello Spring 5 | Root page")
                        )
                )
        );
    }

    public void addRoute(RouterFunction<ServerResponse> route) {
        this.route = this.route.and(route);
    }

    public RouterFunction<ServerResponse> getRoute() {
        return this.route;
    }
}