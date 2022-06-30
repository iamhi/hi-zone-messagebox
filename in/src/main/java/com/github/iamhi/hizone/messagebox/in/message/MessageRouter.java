package com.github.iamhi.hizone.messagebox.in.message;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class MessageRouter {

    public static final String ROUTER_PREFIX = "/message";

    @Bean
    public RouterFunction<ServerResponse> messageRouterCompose(MessageHandler messageHandler) {
        return route(GET(ROUTER_PREFIX).and(accept(MediaType.APPLICATION_JSON)), messageHandler::myMessages)
            .and(route(POST(ROUTER_PREFIX).and(accept(MediaType.APPLICATION_JSON)), messageHandler::sendMessage));
    }
}
