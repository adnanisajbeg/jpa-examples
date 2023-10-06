package com.example.simplereactivepostgresexample.controller;


import com.example.simplereactivepostgresexample.model.dto.NewTopicRequest;
import com.example.simplereactivepostgresexample.model.dto.TopicDto;
import com.example.simplereactivepostgresexample.model.dto.UpdateTopicRequest;
import com.example.simplereactivepostgresexample.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/topic")
@AllArgsConstructor
public class TopicController {
    private final TopicService topicService;

    @GetMapping(value = "/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<TopicDto> getAll() {
        return topicService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<TopicDto> getById(@PathVariable("id") UUID id) {
        return topicService.findById(id);
    }

    @PostMapping("/create")
    public Mono<TopicDto> create(@RequestBody Mono<NewTopicRequest> newTopicRequest) {
        return topicService.create(newTopicRequest);
    }

    @PatchMapping("/update/{topicId}")
    public Mono<TopicDto> update(@PathVariable("topicId") UUID topicId,
            @RequestBody Mono<UpdateTopicRequest> updateTopicRequestMono) {
        return topicService.update(topicId, updateTopicRequestMono);
    }
}
