package com.example.simplereactivepostgresexample.service;


import com.example.simplereactivepostgresexample.mapper.CommentMapper;
import com.example.simplereactivepostgresexample.model.dto.CommentDto;
import com.example.simplereactivepostgresexample.model.dto.NewCommentRequest;
import com.example.simplereactivepostgresexample.repository.CommentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Flux<CommentDto> findAllByTopicId(UUID topicId) {
        return commentRepository.findAllByVisibleTrueAndTopicId(topicId)
                .map(CommentMapper.COMMENT_MAPPER::toCommentDto)
                .doOnComplete(() -> log.info("All comments retrieved"));
    }

    public Mono<CommentDto> addCommentToTopic(UUID topicId,
                                              Mono<NewCommentRequest> newCommentRequest) {
        return newCommentRequest
                .map(CommentMapper.COMMENT_MAPPER::toCommentFromRequest)
                .map(comment -> {
                    OffsetDateTime now = OffsetDateTime.now();

                    comment.setTopicId(topicId)
                            .setCreatedAt(now)
                            .setUpdatedAt(now);

                    return comment;
                })
                .flatMap(commentRepository::save)
                .map(CommentMapper.COMMENT_MAPPER::toCommentDto)
                .doOnSuccess(comment -> log.info("Comment created: {}", comment));

    }
}
