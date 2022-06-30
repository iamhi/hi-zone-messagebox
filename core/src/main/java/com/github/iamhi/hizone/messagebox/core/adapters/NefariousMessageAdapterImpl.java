package com.github.iamhi.hizone.messagebox.core.adapters;

import com.github.iamhi.hizone.messagebox.core.DeviousMessageService;
import com.github.iamhi.hizone.messagebox.core.SpyingUserService;
import com.github.iamhi.hizone.messagebox.inadapter.NefariousMessageAdapter;
import com.github.iamhi.hizone.messagebox.inadapter.models.ExternalUserResponse;
import com.github.iamhi.hizone.messagebox.inadapter.models.MessageResponse;
import com.github.iamhi.hizone.messagebox.outadapter.models.MessageDto;
import com.github.iamhi.hizone.messagebox.outadapter.models.UserDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
record NefariousMessageAdapterImpl(
    DeviousMessageService deviousMessageService,
    SpyingUserService spyingUserService
) implements NefariousMessageAdapter {
    @Override
    public Flux<MessageResponse> findMyMessages(ExternalUserResponse externalUserResponse) {
        return spyingUserService.getUserWithExternals(toDto(externalUserResponse))
            .flatMapMany(deviousMessageService::getMyMessages)
            .map(this::toResponse);
    }

    @Override
    public Mono<MessageResponse> sendMessage(String content, String receiver, ExternalUserResponse externalUserResponse) {
        return spyingUserService.getUserWithExternals(toDto(externalUserResponse)).flatMap(userDto ->
                (receiver != null && !userDto.username().equals(receiver)) ?
                    deviousMessageService.sendMessageTo(content, receiver, userDto)
                    : deviousMessageService.sendMessageToSelf(content, userDto))
            .map(this::toResponse);
    }

    UserDto toDto(ExternalUserResponse externalUserResponse) {
        return new UserDto(
            null,
            externalUserResponse.username(),
            externalUserResponse.externalUuid(),
            null,
            null
        );
    }

    MessageResponse toResponse(MessageDto messageDto) {
        return new MessageResponse(
            messageDto.uuid(),
            messageDto.content(),
            messageDto.createdBy(),
            messageDto.createdAt()
        );
    }
}
