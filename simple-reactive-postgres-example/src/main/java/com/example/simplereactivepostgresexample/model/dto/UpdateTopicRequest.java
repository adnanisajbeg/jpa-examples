package com.example.simplereactivepostgresexample.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UpdateTopicRequest {
    @NotNull
    @NotBlank
    @Max(255)
    private String title;
    @NotNull
    @NotBlank
    @Max(1500)
    private String description;
}
