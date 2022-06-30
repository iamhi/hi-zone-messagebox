package com.github.iamhi.hizone.messagebox.outadapter;

import com.github.iamhi.hizone.messagebox.outadapter.models.UserDto;
import reactor.core.publisher.Mono;

public interface SecretUserRepositoryAdapter {

    Mono<UserDto> create(UserDto userDto);

    Mono<UserDto> getByUuid(String uuid);

    Mono<UserDto> getByUsername(String username);

    Mono<UserDto> getByExternalUuid(String externalUuid);
}
