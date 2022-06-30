package com.github.iamhi.hizone.messagebox.outadapter.models;

import java.time.Instant;

public record UserDto(
    String uuid,
    String username,
    String externalUuid,
    String boxUuid,
    Instant createdAt
) {
}
