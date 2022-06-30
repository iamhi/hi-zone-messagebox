package com.github.iamhi.hizone.messagebox.inadapter;

import com.github.iamhi.hizone.messagebox.inadapter.models.ExternalUserResponse;
import com.github.iamhi.hizone.messagebox.inadapter.models.MessageResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NefariousMessageAdapter {

    Flux<MessageResponse> findMyMessages(ExternalUserResponse externalUserResponse);

    Mono<MessageResponse> sendMessage(String content, String receiver, ExternalUserResponse externalUserResponse);
}
