package com.example.simplereactivepostgresexample.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;
import java.util.UUID;

public class NewCommentRequest {
    @NotNull
    @NotBlank
    @Max(1000)
    private String commentText;
    @NotNull
    @NotBlank
    @Max(255)
    private String author;
}
