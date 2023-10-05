package com.example.simplepostgresexample.models.dto;

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
public class NewCompanyRequest {
    @NotNull
    @NotBlank
    @Max(255)
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
