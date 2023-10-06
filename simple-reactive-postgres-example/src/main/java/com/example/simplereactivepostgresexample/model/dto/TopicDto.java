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
public class TopicDto {
    private UUID id;
    private String title;
    private String description;
    private String author;
    private boolean visible;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
