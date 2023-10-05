package com.example.searchbycriteriaexample.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "logs", schema = "logs")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String log;
    private String logUser;
    private String logGroup;
    private String level;
    private OffsetDateTime createdAt = OffsetDateTime.now();
}
