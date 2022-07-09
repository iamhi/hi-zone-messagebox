package com.github.iamhi.hizone.messagebox.out.postgres;

import com.github.iamhi.hizone.messagebox.out.postgres.models.MessageEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MessageRepository extends ReactiveCrudRepository<MessageEntity, Integer> {

    Flux<MessageEntity> findByOwningBoxUuid(String owningBoxUuid);
}
