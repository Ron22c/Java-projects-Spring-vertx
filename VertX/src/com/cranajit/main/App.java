package com.cranajit.main;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        HttpServer server = vertx.createHttpServer();
        Router router = Router.router(vertx);
        router.get("/:nsme").handler(routingContext -> {
            String name = routingContext.pathParam("nsme");
            List<String> age = routingContext.queryParam("age");
            for(String a:age) {
                System.out.println(a);
            }
            HttpServerResponse response = routingContext.response();
            response.putHeader("Content-Type", "text/html");
            response.end("<h1>HELLO: "+name+"</h1>");
        });
        server.requestHandler(router).listen(8080);
    }
}