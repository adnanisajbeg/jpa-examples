package com.example.simplereactivepostgresexample.repository;

import com.example.simplereactivepostgresexample.model.Comment;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface CommentRepository extends R2dbcRepository<Comment, UUID> {
    Flux<Comment> findAllByVisibleTrueAndTopicId(UUID topicId);

}
