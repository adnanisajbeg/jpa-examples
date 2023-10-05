package com.example.searchbycriteriaexample.config;

import com.example.searchbycriteriaexample.properties.DbProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataConfig {
    @Bean
    public DataSource getDataSource(DbProperties dbProperties) {
        return DataSourceBuilder.create()
                .driverClassName(dbProperties.getDriverClassName())
                .url(dbProperties.getUrl())
                .username(dbProperties.getUsername())
                .password(dbProperties.getPassword())
                .build();
    }
}
