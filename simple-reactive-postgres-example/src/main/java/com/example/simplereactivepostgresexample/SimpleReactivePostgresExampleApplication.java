package com.example.simplereactivepostgresexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories
public class SimpleReactivePostgresExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleReactivePostgresExampleApplication.class, args);
    }

}
