package com.example.simplereactivepostgresexample.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;
import java.util.UUID;

public class NewCommentRequest {
    @NotNull(message = "Topic id should not be null")
    @NotBlank(message = "Topic id should not be blank")
    @Max(value = 1000, message = "Topic id should be less than 1000 characters")
    private String commentText;
    @NotNull(message = "Author should not be null")
    @NotBlank(message = "Author should not be blank")
    @Max(value = 255, message = "Author should be less than 255 characters")
    private String author;
}
