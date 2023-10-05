package com.example.simplepostgresexample.models.dto;

import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class CompanyWithActiveDivisionsDto {
    private UUID id;
    private String name;
    private String shortName;
    private String hqAddress;
    Set<DivisionDto> activeDivisions;
}
