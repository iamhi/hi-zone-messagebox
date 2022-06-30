package com.github.iamhi.hizone.messagebox.outadapter;

import com.github.iamhi.hizone.messagebox.outadapter.models.MessageDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InsidiousMessageRepositoryAdapter {

    Mono<MessageDto> create(MessageDto messageDto);

    Flux<MessageDto> getMessages(String boxUuid);
}
