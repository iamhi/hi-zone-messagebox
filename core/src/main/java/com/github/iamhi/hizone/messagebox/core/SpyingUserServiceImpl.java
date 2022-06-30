package com.github.iamhi.hizone.messagebox.core;

import com.github.iamhi.hizone.messagebox.outadapter.SecretUserRepositoryAdapter;
import com.github.iamhi.hizone.messagebox.outadapter.models.UserDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.UUID;

@Service
record SpyingUserServiceImpl(
    SecretUserRepositoryAdapter repositoryAdapter
) implements SpyingUserService {

    @Override
    public Mono<UserDto> getUserWithExternals(UserDto userDto) {
        return repositoryAdapter.getByExternalUuid(userDto.externalUuid())
            .switchIfEmpty(repositoryAdapter.create(new UserDto(
                UUID.randomUUID().toString(),
                userDto.username(),
                userDto.externalUuid(),
                UUID.randomUUID().toString(),
                Instant.now()
            )))
            .flatMap(user ->
                (user.username().equals(userDto.username())) ?
                    Mono.just(user) : Mono.error(RuntimeException::new));
    }

    @Override
    public Mono<UserDto> getUserWithUsername(String username) {
        return repositoryAdapter
            .getByUsername(username)
            .switchIfEmpty(Mono.error(RuntimeException::new));
    }

    @Override
    public Mono<UserDto> getUserWithUuid(String uuid) {
        return repositoryAdapter
            .getByUuid(uuid)
            .switchIfEmpty(Mono.error(RuntimeException::new));
    }
}
