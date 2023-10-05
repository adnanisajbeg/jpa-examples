package com.example.simplepostgresexample.repository;

import com.example.simplepostgresexample.models.dao.CompanyDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyDao, UUID> {
    List<CompanyDao> findByName(String name);
    Set<CompanyDao> findByNameContainingIgnoreCaseOrderByNameDesc(String name);
}
