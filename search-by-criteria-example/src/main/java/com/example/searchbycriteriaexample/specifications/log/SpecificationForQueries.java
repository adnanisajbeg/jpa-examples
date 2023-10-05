package com.example.searchbycriteriaexample.specifications.log;

import com.example.searchbycriteriaexample.model.Log;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationForQueries {
    public static Specification<Log> hasTermInFieldLike(String field, String term) {
        return (log, cq, cb) -> cb.like(log.get(field),  "%" + term + "%");
    }

    public static Specification<Log> hasTermInFieldEqual(String field, String term) {
        return (log, cq, cb) -> cb.equal(log.get(field),  term );
    }
}
