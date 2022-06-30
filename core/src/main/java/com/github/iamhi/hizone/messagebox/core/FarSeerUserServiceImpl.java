package com.github.iamhi.hizone.messagebox.core;

import com.github.iamhi.hizone.messagebox.outadapter.ImaginaryAuthService;
import com.github.iamhi.hizone.messagebox.outadapter.models.UserDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public record FarSeerUserServiceImpl (ImaginaryAuthService imaginaryAuthService) implements FarSeerUserService {

    @Override
    public Mono<UserDto> findUser(String userToken) {
        return imaginaryAuthService.findUser(userToken);
    }
}
