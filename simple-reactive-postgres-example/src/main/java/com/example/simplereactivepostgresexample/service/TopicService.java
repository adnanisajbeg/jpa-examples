package com.example.simplereactivepostgresexample.service;

import com.example.simplereactivepostgresexample.mapper.TopicMapper;
import com.example.simplereactivepostgresexample.model.Topic;
import com.example.simplereactivepostgresexample.model.dto.NewTopicRequest;
import com.example.simplereactivepostgresexample.model.dto.TopicDto;
import com.example.simplereactivepostgresexample.model.dto.UpdateTopicRequest;
import com.example.simplereactivepostgresexample.repository.TopicsRepository;
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
public class TopicService {
    private final TopicsRepository topicsRepository;

    public Mono<TopicDto> findById(UUID id) {
        return topicsRepository.findById(id)
                .map(TopicMapper.TOPIC_MAPPER::toTopicDto)
                .doOnSuccess(topicDto -> log.info("Topic retrieved: {}", topicDto));
    }

    public Flux<TopicDto> findAll() {
        return topicsRepository.findAllByVisible(true)
                .map(TopicMapper.TOPIC_MAPPER::toTopicDto)
                .doOnComplete(() -> log.info("All topics retrieved"));
    }

    public Mono<TopicDto> create(Mono<NewTopicRequest> newTopicRequest) {
        return newTopicRequest
                .map(TopicMapper.TOPIC_MAPPER::toTopicFromNewRequest)
                .flatMap(topic -> {
                    OffsetDateTime now = OffsetDateTime.now();

                    return Mono.justOrEmpty(topic.setCreatedAt(now)
                            .setUpdatedAt(now)
                            .setVisible(true));

                })
                .flatMap(topicsRepository::save)
                .map(TopicMapper.TOPIC_MAPPER::toTopicDto)
                .doOnSuccess(topic -> log.info("Topic created: {}", topic));
    }

    public Mono<TopicDto> update(UUID topicId, Mono<UpdateTopicRequest> updateTopicRequest) {
        return updateTopicRequest
                .zipWith(topicsRepository.findById(topicId))
                .flatMap(tuple -> {
                    UpdateTopicRequest updateTopicRequest1 = tuple.getT1();
                    Topic topic = tuple.getT2();
                    TopicMapper.TOPIC_MAPPER.updateTopicFromUpdateRequest(updateTopicRequest1, topic);
                    return topicsRepository.save(topic);
                })
                .map(TopicMapper.TOPIC_MAPPER::toTopicDto)
                .doOnSuccess(topic -> log.info("Topic updated: {}", topic));
    }
}
