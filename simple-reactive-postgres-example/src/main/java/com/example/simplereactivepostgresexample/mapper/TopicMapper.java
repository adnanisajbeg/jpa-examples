package com.example.simplereactivepostgresexample.mapper;

import com.example.simplereactivepostgresexample.model.Topic;
import com.example.simplereactivepostgresexample.model.dto.NewTopicRequest;
import com.example.simplereactivepostgresexample.model.dto.TopicDto;
import com.example.simplereactivepostgresexample.model.dto.UpdateTopicRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TopicMapper {
    TopicMapper TOPIC_MAPPER = Mappers.getMapper(TopicMapper.class);

    TopicDto toTopicDto(Topic topic);

    Topic toTopicFromNewRequest(NewTopicRequest newTopicRequest);


    void updateTopicFromUpdateRequest(UpdateTopicRequest updateTopicRequest,
                                      @MappingTarget Topic topic);

}
