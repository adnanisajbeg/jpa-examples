package com.example.simplereactivepostgresexample.controller;

import com.example.simplereactivepostgresexample.model.dto.CommentDto;
import com.example.simplereactivepostgresexample.model.dto.NewCommentRequest;
import com.example.simplereactivepostgresexample.service.CommentService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/{topicId}")
    public Flux<CommentDto> getAllByTopicId(@PathVariable("topicId") @NotNull UUID topicId) {
        return commentService.findAllByTopicId(topicId);
    }

    @PostMapping("/{topicId}")
    public Mono<CommentDto> addCommentToTopic(@PathVariable("topicId") @NotNull UUID topicId,
                                              @RequestBody Mono<NewCommentRequest> newCommentRequest) {
        return commentService.addCommentToTopic(topicId, newCommentRequest);
    }
}
