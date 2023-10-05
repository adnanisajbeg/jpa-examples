package com.example.searchbycriteriaexample.service;

import com.example.searchbycriteriaexample.mapper.LogMapper;
import com.example.searchbycriteriaexample.model.Log;
import com.example.searchbycriteriaexample.model.dto.NewLog;
import com.example.searchbycriteriaexample.repository.LogsRepository;
import com.example.searchbycriteriaexample.specifications.log.SpecificationForQueries;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

import static org.springframework.data.jpa.domain.Specification.where;

@Service
@AllArgsConstructor
@Slf4j
public class LogService {
    private final LogsRepository logsRepository;
    private final LogMapper logMapper;

    public Log addLog(NewLog newLog) {
        Log log = logMapper.toLog(newLog);
        log.setCreatedAt(OffsetDateTime.now());
        return logsRepository.save(log);
    }

    public List<Log> searchLogs(List<String> fields, String term) {
        return logsRepository.findAll(createQuery(fields, term));
    }

    private Specification<Log> createQuery(List<String> fields, String term) {
        if (fields == null || fields.isEmpty()) {
            return where(SpecificationForQueries.hasTermInFieldLike("log", term));
        };

        Specification<Log> where = where(SpecificationForQueries.hasTermInFieldLike(fields.get(0), term));

        if (fields.size() == 1) {
            return where;
        }

        for (int i = 1; i < fields.size(); i++) {
            where = where.or(SpecificationForQueries.hasTermInFieldLike(fields.get(i), term));
        }

        return where;
    }

}
