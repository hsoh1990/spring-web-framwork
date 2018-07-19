package wisoft.io.spring.functionapi;

import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.*;
import reactor.ipc.netty.http.server.HttpServer;
import wisoft.io.spring.functionapi.account.AccountRouter;


public class Server {
    public static final String HOST = "localhost";
    public static final int PORT = 8090;

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.startReactorServer();
        System.out.println("Server Start & Press ENTER to exit.");
        System.in.read();
    }

    public void startReactorServer() throws InterruptedException {

        AccountRouter accountRouter = new AccountRouter();

        ApiRouter.getInstance().addRoute(accountRouter.routingFunction());

        HttpHandler httpHandler = RouterFunctions.toHttpHandler(ApiRouter.getInstance().getRoute());
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);

        HttpServer server = HttpServer.create(HOST, PORT);
        server.newHandler(adapter).block();
    }
}
