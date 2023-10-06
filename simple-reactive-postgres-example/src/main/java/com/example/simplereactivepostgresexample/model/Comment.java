package com.example.simplereactivepostgresexample.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;
import java.util.UUID;

@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "comment", schema = "forum")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String commentText;
    private String author;
    private boolean visible = true;
    private UUID topicId;
    @CreatedDate
    private OffsetDateTime createdAt = OffsetDateTime.now();
    @LastModifiedDate
    private OffsetDateTime updatedAt = OffsetDateTime.now();
}
