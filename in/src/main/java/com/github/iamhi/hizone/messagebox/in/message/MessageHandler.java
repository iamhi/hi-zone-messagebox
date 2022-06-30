package com.github.iamhi.hizone.messagebox.in.message;

import com.github.iamhi.hizone.messagebox.in.shared.CookieHandler;
import com.github.iamhi.hizone.messagebox.inadapter.FarSeerUserServiceAdapter;
import com.github.iamhi.hizone.messagebox.inadapter.NefariousMessageAdapter;
import com.github.iamhi.hizone.messagebox.inadapter.models.MessageResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public record MessageHandler(
    CookieHandler cookieHandler,
    FarSeerUserServiceAdapter userServiceAdapter,
    NefariousMessageAdapter messageAdapter
) {
    Mono<ServerResponse> myMessages(ServerRequest serverRequest) {
        return cookieHandler.getUserToken(serverRequest.cookies()).
            flatMap(userServiceAdapter::findUser)
            .flatMap(user -> ServerResponse.ok().body(messageAdapter.findMyMessages(user), MessageResponse.class))
            .doOnError(throwable -> ServerResponse.badRequest().bodyValue(throwable));
    }

    Mono<ServerResponse> sendMessage(ServerRequest serverRequest) {
        return Mono.zip(
                cookieHandler.getUserToken(serverRequest.cookies()).
                    flatMap(userServiceAdapter::findUser),
                serverRequest.bodyToMono(SendMessageRequest.class)
            ).flatMap(t2 -> messageAdapter.sendMessage(t2.getT2().content(), t2.getT2().receiver(), t2.getT1()))
            .flatMap(ServerResponse.ok()::bodyValue)
            .doOnError(throwable -> ServerResponse.badRequest().bodyValue(throwable));
    }
}
