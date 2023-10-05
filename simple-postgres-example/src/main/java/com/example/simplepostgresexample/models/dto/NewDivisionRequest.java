package com.example.simplepostgresexample.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewDivisionRequest {
    private String name;
    private String mainAddress;
    private UUID companyId;

}
