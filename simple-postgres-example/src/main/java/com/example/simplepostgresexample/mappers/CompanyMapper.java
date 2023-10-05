package com.example.simplepostgresexample.mappers;

import com.example.simplepostgresexample.models.dao.CompanyDao;
import com.example.simplepostgresexample.models.dao.CompanyDivisionDao;
import com.example.simplepostgresexample.models.dto.CompanyWithActiveDivisionsDto;
import com.example.simplepostgresexample.models.dto.DivisionDto;
import com.example.simplepostgresexample.models.dto.NewCompanyRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.LinkedHashSet;
import java.util.Set;

import static com.example.simplepostgresexample.mappers.DivisionMapper.DIVISION_MAPPER;

@Mapper(componentModel = "spring", uses = DivisionMapper.class)
public interface CompanyMapper {

    CompanyMapper COMPANY_MAPPER = Mappers.getMapper(CompanyMapper.class);

    @Mapping(target = "activeDivisions", source = "activeDivisions", qualifiedByName = "toCompanyWIthActiveDivisionsDto")
    CompanyWithActiveDivisionsDto toCompanyWIthActiveDivisionsDto(CompanyDao companyDao);
    CompanyDao toDaoFromNewRequest(NewCompanyRequest newCompanyRequest);

    @Named("toCompanyWIthActiveDivisionsDto")
    default Set<DivisionDto> companyDivisionDaoSetToDivisionDtoSet(Set<CompanyDivisionDao> set) {
        if ( set == null || set.isEmpty()) {
            return null;
        }

        Set<DivisionDto> set1 = new LinkedHashSet<>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CompanyDivisionDao companyDivisionDao : set ) {
            set1.add(DIVISION_MAPPER.toDivisionDao( companyDivisionDao ) );
        }

        return set1;
    }
}
