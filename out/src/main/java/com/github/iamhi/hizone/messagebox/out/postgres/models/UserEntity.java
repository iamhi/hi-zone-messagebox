package com.github.iamhi.hizone.messagebox.out.postgres.models;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table
public record UserEntity(

    @Column("uuid")
    String uuid,

    @Column("username")
    String username,

    @Column("external_uuid")
    String externalUuid,

    @Column("box_uuid")
    String boxUuid,

    @Column("created_at")
    Instant createdAt
) {
}
