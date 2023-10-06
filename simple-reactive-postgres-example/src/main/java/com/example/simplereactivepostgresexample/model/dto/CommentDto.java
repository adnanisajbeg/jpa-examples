package com.example.simplereactivepostgresexample.model.dto;


import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private UUID id;
    private String commentText;
    private String author;
    private boolean visible;
    private UUID topicId;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
