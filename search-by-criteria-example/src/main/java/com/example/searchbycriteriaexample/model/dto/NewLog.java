package com.example.searchbycriteriaexample.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NewLog {
    @NotNull
    @NotBlank
    @Max(255)
    private String log;
    private String logUser;
    private String logGroup;
    private String level;
}
