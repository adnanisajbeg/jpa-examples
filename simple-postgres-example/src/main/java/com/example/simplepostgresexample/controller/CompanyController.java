package com.example.simplepostgresexample.controller;


import com.example.simplepostgresexample.models.dto.CompanyWithActiveDivisionsDto;
import com.example.simplepostgresexample.models.dto.NewCompanyRequest;
import com.example.simplepostgresexample.service.CompanyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/companies", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompanyController {
    private CompanyService companyService;

    @GetMapping("/search")
    public Set<CompanyWithActiveDivisionsDto>
    searchCompanies(@RequestParam("term") String name) {
        return companyService.findCompaniesContainingTerm(name);
    }

    @PostMapping("/new")
    public CompanyWithActiveDivisionsDto createCompany(@RequestBody NewCompanyRequest newCompanyRequest) {
        return companyService.createCompany(newCompanyRequest);
    }
}
