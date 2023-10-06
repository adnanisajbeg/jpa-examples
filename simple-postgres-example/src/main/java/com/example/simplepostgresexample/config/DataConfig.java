package com.example.simplepostgresexample.config;

import com.example.simplepostgresexample.properties.DbProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataConfig {
    @Bean
    public DataSource getDataSource(DbProperties dbProperties) {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://localhost:5432/postgres")
                .username("user")
                .password("user")
                .build();
    }
}
