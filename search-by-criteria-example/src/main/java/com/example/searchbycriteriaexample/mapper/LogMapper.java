package com.example.searchbycriteriaexample.mapper;

import com.example.searchbycriteriaexample.model.Log;
import com.example.searchbycriteriaexample.model.dto.NewLog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LogMapper {
    Log toLog(NewLog newLog);
}
