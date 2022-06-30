package com.github.iamhi.hizone.messagebox.out.mongodb;

import com.github.iamhi.hizone.messagebox.out.mongodb.models.UserEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<UserEntity, String> {

    Mono<UserEntity> findByExternalUuid(String externalUuid);

    Mono<UserEntity> findByUsername(String username);
}
