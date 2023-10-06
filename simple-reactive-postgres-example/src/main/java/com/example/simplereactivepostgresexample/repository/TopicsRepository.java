package com.example.simplereactivepostgresexample.repository;

import com.example.simplereactivepostgresexample.model.Topic;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface TopicsRepository extends R2dbcRepository<Topic, UUID> {
    Flux<Topic> findAllByVisible(boolean visible);
}
