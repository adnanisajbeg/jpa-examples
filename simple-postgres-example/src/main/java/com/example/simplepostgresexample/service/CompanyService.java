package com.example.simplepostgresexample.service;

import com.example.simplepostgresexample.models.dto.CompanyWithActiveDivisionsDto;
import com.example.simplepostgresexample.models.dto.NewCompanyRequest;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

import java.util.Set;

public interface CompanyService {

    @Retryable(backoff = @Backoff(delay = 1000), maxAttempts = 3)
    Set<CompanyWithActiveDivisionsDto> findCompaniesContainingTerm(String term);

    CompanyWithActiveDivisionsDto createCompany(NewCompanyRequest newCompanyRequest);
}
