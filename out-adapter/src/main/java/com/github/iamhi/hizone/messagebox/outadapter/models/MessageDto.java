package com.github.iamhi.hizone.messagebox.outadapter.models;

import java.time.Instant;

public record MessageDto(
    String uuid,
    String content,
    String createdBy,
    String owningBoxUuid,
    Instant createdAt
) {
}
