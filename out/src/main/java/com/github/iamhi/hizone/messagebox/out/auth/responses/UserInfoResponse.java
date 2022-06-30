package com.github.iamhi.hizone.messagebox.out.auth.responses;

import java.util.List;

public record UserInfoResponse(
    String uuid,

    String username,

    String email,

    List<String> roles
) {
}
