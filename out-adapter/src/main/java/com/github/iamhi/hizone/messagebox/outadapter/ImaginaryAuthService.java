package com.github.iamhi.hizone.messagebox.outadapter;

import com.github.iamhi.hizone.messagebox.outadapter.models.UserDto;
import reactor.core.publisher.Mono;

public interface ImaginaryAuthService {

    Mono<UserDto> findUser(String token);
}
