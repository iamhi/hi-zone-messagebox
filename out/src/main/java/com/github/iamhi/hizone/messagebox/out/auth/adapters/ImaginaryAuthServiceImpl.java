package com.github.iamhi.hizone.messagebox.out.auth.adapters;

import com.github.iamhi.hizone.messagebox.out.auth.AuthenticationClient;
import com.github.iamhi.hizone.messagebox.out.auth.responses.UserInfoResponse;
import com.github.iamhi.hizone.messagebox.outadapter.ImaginaryAuthService;
import com.github.iamhi.hizone.messagebox.outadapter.models.UserDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public record ImaginaryAuthServiceImpl(
    AuthenticationClient authenticationClient
) implements ImaginaryAuthService {
    @Override
    public Mono<UserDto> findUser(String token) {
        return authenticationClient.isConnected().flatMap(
                isConnected -> Boolean.TRUE.equals(isConnected) ?
                    Mono.just(true)
                    : authenticationClient.connect()
            ).flatMap(connected -> authenticationClient.fetchUserInfo(token))
            .map(this::map);
    }

    UserDto map(UserInfoResponse userInfoResponse) {
        return new UserDto(
            null,
            userInfoResponse.username(),
            userInfoResponse.uuid(),
            null,
            null
        );
    }
}
