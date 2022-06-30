package com.github.iamhi.hizone.messagebox.out.mongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document
public record MessageEntity(

    @Id
    String uuid,

    String content,

    String createdBy,

    String owningBoxUuid,

    Instant createdAt
) {
}
