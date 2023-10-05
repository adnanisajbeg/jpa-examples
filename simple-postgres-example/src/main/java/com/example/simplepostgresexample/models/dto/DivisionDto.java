package com.example.simplepostgresexample.models.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class DivisionDto {
    private UUID id;
    private String name;
    private String mainAddress;
}
