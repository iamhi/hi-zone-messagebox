package com.github.iamhi.hizone.messagebox.out.postgres;

import com.github.iamhi.hizone.messagebox.out.postgres.models.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<UserEntity, Integer> {

    Mono<UserEntity> findByExternalUuid(String externalUuid);

    Mono<UserEntity> findByUsername(String username);

    Mono<UserEntity> findByUuid(String uuid);
}
