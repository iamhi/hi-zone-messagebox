package com.github.iamhi.hizone.messagebox.core;

import com.github.iamhi.hizone.messagebox.outadapter.models.MessageDto;
import com.github.iamhi.hizone.messagebox.outadapter.models.UserDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DeviousMessageService {

    Mono<MessageDto> sendMessageToSelf(String content, UserDto senderExternals);

    Mono<MessageDto> sendMessageTo(String content, String receiverUsername, UserDto senderExternals);

    Flux<MessageDto> getMyMessages(UserDto senderExternals);
}
