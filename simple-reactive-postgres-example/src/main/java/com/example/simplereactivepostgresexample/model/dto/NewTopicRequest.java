package com.example.simplereactivepostgresexample.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewTopicRequest {
    @NotNull(message = "Title should not be null")
    @NotBlank(message = "Title should not be blank")
    @Max(value = 255, message = "Title should be less than 255 characters")
    private String title;
    @NotNull(message = "Description should not be null")
    @NotBlank(message = "Description should not be blank")
    @Max(value = 1500, message = "Description should be less than 1500 characters")
    private String description;
    @NotNull(message = "Author should not be null")
    @NotBlank(message = "Author should not be blank")
    @Max(value = 255, message = "Author should be less than 255 characters")
    private String author;
}
