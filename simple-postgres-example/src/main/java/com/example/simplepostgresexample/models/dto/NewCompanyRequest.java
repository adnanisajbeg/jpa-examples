package com.example.simplepostgresexample.models.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class NewCompanyRequest {
    @NotNull
    @NotBlank
    @Max(255)
    @Min(3)
    private String name;
    @NotNull
    @NotBlank
    @Max(255)
    private String shortName;
    @NotNull
    @NotBlank
    @Max(255)
    private String hqAddress;
}
