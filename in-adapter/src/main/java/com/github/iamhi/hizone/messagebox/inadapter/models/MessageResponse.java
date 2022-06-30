package com.github.iamhi.hizone.messagebox.inadapter.models;

import java.time.Instant;

public record MessageResponse(
    String uuid,
    String content,
    String createdBy,
    Instant createdAt
) {
}
