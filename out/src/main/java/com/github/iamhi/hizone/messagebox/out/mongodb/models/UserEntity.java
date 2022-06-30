package com.github.iamhi.hizone.messagebox.out.mongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document
public record UserEntity(

    @Id
    String uuid,

    @Indexed(name = "user_entity_username_index", unique = true, sparse = true)
    String username,

    String externalUuid,

    String boxUuid,

    Instant createdAt
) {
}
