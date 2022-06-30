package com.github.iamhi.hizone.messagebox.out.mongodb;

import com.github.iamhi.hizone.messagebox.out.mongodb.models.MessageEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MessageRepository extends ReactiveMongoRepository<MessageEntity, String> {

    Flux<MessageEntity> findByOwningBoxUuid(String owningBoxUuid);
}
