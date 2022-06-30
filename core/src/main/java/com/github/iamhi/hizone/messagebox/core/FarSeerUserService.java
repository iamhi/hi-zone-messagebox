package com.github.iamhi.hizone.messagebox.core;

import com.github.iamhi.hizone.messagebox.outadapter.models.UserDto;
import reactor.core.publisher.Mono;

public interface FarSeerUserService {

    Mono<UserDto> findUser(String userToken);
}
