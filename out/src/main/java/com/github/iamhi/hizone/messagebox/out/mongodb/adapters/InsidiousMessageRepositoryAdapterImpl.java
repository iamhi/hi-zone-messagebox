package com.github.iamhi.hizone.messagebox.out.mongodb.adapters;

import com.github.iamhi.hizone.messagebox.out.mongodb.MessageRepository;
import com.github.iamhi.hizone.messagebox.out.mongodb.models.MessageEntity;
import com.github.iamhi.hizone.messagebox.outadapter.InsidiousMessageRepositoryAdapter;
import com.github.iamhi.hizone.messagebox.outadapter.models.MessageDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public record InsidiousMessageRepositoryAdapterImpl(
    MessageRepository messageRepository
)
    implements InsidiousMessageRepositoryAdapter {
    @Override
    public Mono<MessageDto> create(MessageDto messageDto) {
        return messageRepository.save(this.toEntity(messageDto)).map(this::toDto);
    }

    @Override
    public Flux<MessageDto> getMessages(String boxUuid) {
        return messageRepository.findByOwningBoxUuid(boxUuid).map(this::toDto);
    }

    MessageDto toDto(MessageEntity entity) {
        return new MessageDto(
            entity.uuid(),
            entity.content(),
            entity.createdBy(),
            entity.owningBoxUuid(),
            entity.createdAt()
        );
    }

    MessageEntity toEntity(MessageDto dto) {
        return new MessageEntity(
            dto.uuid(),
            dto.content(),
            dto.createdBy(),
            dto.owningBoxUuid(),
            dto.createdAt()
        );
    }
}
