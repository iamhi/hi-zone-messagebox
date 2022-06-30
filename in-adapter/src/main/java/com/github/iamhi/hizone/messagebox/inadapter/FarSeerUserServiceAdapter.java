package com.github.iamhi.hizone.messagebox.inadapter;

import com.github.iamhi.hizone.messagebox.inadapter.models.ExternalUserResponse;
import reactor.core.publisher.Mono;

public interface FarSeerUserServiceAdapter {

    Mono<ExternalUserResponse> findUser(String token);
}
