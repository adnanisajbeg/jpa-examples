package com.example.searchbycriteriaexample.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class FlywayConfig implements FlywayMigrationStrategy {
    private final DataSource dataSource;

    public FlywayConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void migrate(Flyway flyway) {
        Flyway.configure().dataSource(dataSource)
                .schemas("logs")
                .locations("classpath:db/migration/logs")
                .load()
                .migrate();
    }
}
