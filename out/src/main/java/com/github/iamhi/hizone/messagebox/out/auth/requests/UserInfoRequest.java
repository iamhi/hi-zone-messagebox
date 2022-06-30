package com.github.iamhi.hizone.messagebox.out.auth.requests;

public record UserInfoRequest (
    String token,
    String userToken
) {
}
