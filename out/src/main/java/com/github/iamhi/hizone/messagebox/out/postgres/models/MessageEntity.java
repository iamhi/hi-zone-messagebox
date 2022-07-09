package com.github.iamhi.hizone.messagebox.out.postgres.models;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table
public record MessageEntity(

    @Column("uuid")
    String uuid,

    @Column("content")
    String content,

    @Column("created_by")
    String createdBy,

    @Column("owning_box_uuid")
    String owningBoxUuid,

    @Column("created_at")
    Instant createdAt
) {
}
