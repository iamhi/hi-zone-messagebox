package com.github.iamhi.hizone.messagebox.core;

import com.github.iamhi.hizone.messagebox.outadapter.InsidiousMessageRepositoryAdapter;
import com.github.iamhi.hizone.messagebox.outadapter.models.MessageDto;
import com.github.iamhi.hizone.messagebox.outadapter.models.UserDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.UUID;

@Service
record DeviousMessageServiceImpl(
    SpyingUserService spyingUserService,
    InsidiousMessageRepositoryAdapter repositoryAdapter
) implements DeviousMessageService {

    @Override
    public Mono<MessageDto> sendMessageToSelf(String content, UserDto sender) {
        return repositoryAdapter.create(
            new MessageDto(
                UUID.randomUUID().toString(),
                content,
                sender.username(),
                sender.boxUuid(),
                Instant.now()
            )
        );
    }

    @Override
    public Mono<MessageDto> sendMessageTo(String content, String receiverUsername, UserDto sender) {
        return spyingUserService.getUserWithUsername(receiverUsername).switchIfEmpty(Mono.error(RuntimeException::new))
            .flatMap(receiver -> repositoryAdapter.create(
                new MessageDto(
                    UUID.randomUUID().toString(),
                    content,
                    sender.username(),
                    receiver.boxUuid(),
                    Instant.now()
                )
            ));
    }

    @Override
    public Flux<MessageDto> getMyMessages(UserDto user) {
        return repositoryAdapter.getMessages(user.boxUuid());
    }
}
