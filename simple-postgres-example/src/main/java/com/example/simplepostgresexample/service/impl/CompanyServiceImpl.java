package com.example.simplepostgresexample.service.impl;

import com.example.simplepostgresexample.mappers.CompanyMapper;
import com.example.simplepostgresexample.models.dao.CompanyDao;
import com.example.simplepostgresexample.models.dto.CompanyWithActiveDivisionsDto;
import com.example.simplepostgresexample.models.dto.NewCompanyRequest;
import com.example.simplepostgresexample.repository.CompanyRepository;
import com.example.simplepostgresexample.service.CompanyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    @Override
    @Cacheable(value = "companies", key = "#term", cacheManager = "caffeineCacheManager")
    public Set<CompanyWithActiveDivisionsDto> findCompaniesContainingTerm(String term) {
        log.info("Searching for companies containing term: {}", term);

        if (term == null || term.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        if (term.length() < 3) {
            throw new IllegalArgumentException("Name must be at least 3 characters long");
        }

        return companyRepository.findByNameContainingIgnoreCaseOrderByNameDesc(term)
                .stream()
                .parallel()
                .map(companyMapper::toCompanyWIthActiveDivisionsDto)
                .collect(Collectors.toSet());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    @CacheEvict(value = "companies", allEntries = true)
    public CompanyWithActiveDivisionsDto createCompany(NewCompanyRequest newCompanyRequest) {
        log.info("Creating new company: {}", newCompanyRequest);

        CompanyDao companyDao = companyMapper.toDaoFromNewRequest(newCompanyRequest);
        return companyMapper
                .toCompanyWIthActiveDivisionsDto(companyRepository
                        .save(companyDao));
    }
}
