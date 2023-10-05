package com.example.simplepostgresexample.repository;

import com.example.simplepostgresexample.models.dao.CompanyDivisionDao;
import com.example.simplepostgresexample.models.enums.CompanyDivisionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface CompanyDivisionRepository extends JpaRepository<CompanyDivisionDao, UUID> {
    Set<CompanyDivisionDao> findByStatus(CompanyDivisionStatus status);
}
