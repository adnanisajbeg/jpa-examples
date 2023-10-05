package com.example.searchbycriteriaexample.repository;

import com.example.searchbycriteriaexample.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LogsRepository extends JpaRepository<Log, UUID>, JpaSpecificationExecutor<Log> {
}
