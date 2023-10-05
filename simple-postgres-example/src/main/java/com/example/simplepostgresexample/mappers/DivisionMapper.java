package com.example.simplepostgresexample.mappers;

import com.example.simplepostgresexample.models.dao.CompanyDivisionDao;
import com.example.simplepostgresexample.models.dto.DivisionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DivisionMapper {
    DivisionMapper DIVISION_MAPPER = Mappers.getMapper(DivisionMapper.class);

    DivisionDto toDivisionDao(CompanyDivisionDao divisionName);
}
