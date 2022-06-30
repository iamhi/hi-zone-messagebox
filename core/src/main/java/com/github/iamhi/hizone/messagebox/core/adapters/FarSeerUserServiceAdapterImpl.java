package com.github.iamhi.hizone.messagebox.core.adapters;

import com.github.iamhi.hizone.messagebox.core.FarSeerUserService;
import com.github.iamhi.hizone.messagebox.inadapter.FarSeerUserServiceAdapter;
import com.github.iamhi.hizone.messagebox.inadapter.models.ExternalUserResponse;
import com.github.iamhi.hizone.messagebox.outadapter.models.UserDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
record FarSeerUserServiceAdapterImpl(
    FarSeerUserService farSeerUserService
) implements FarSeerUserServiceAdapter {
    @Override
    public Mono<ExternalUserResponse> findUser(String token) {
        return farSeerUserService.findUser(token).map(this::toResponse);
    }

    ExternalUserResponse toResponse(UserDto userDto) {
        return new ExternalUserResponse(
            userDto.externalUuid(),
            userDto.username()
        );
    }
}
