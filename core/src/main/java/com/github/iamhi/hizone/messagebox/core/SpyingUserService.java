package com.github.iamhi.hizone.messagebox.core;

import com.github.iamhi.hizone.messagebox.outadapter.models.UserDto;
import reactor.core.publisher.Mono;

public interface SpyingUserService {

    Mono<UserDto> getUserWithExternals(UserDto userDto);

    Mono<UserDto> getUserWithUsername(String username);

    Mono<UserDto> getUserWithUuid(String uuid);
}
