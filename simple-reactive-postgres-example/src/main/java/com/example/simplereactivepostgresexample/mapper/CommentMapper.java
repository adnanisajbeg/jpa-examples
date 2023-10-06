package com.example.simplereactivepostgresexample.mapper;

import com.example.simplereactivepostgresexample.model.Comment;
import com.example.simplereactivepostgresexample.model.dto.CommentDto;
import com.example.simplereactivepostgresexample.model.dto.NewCommentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentMapper COMMENT_MAPPER = Mappers.getMapper(CommentMapper.class);

    CommentDto toCommentDto(Comment comment);
    Comment toCommentFromRequest(NewCommentRequest newCommentRequest);
}
