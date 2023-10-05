package com.example.simplepostgresexample.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.TimeUnit;

@Getter
@Configuration
@EnableCaching
public class CaffeineCacheConfig {
    private final int initialCapacity;
    private final long maximumSize;
    private final int expireAfterAccess;
    private final int expireAfterWrite;
    private final int refreshAfterWrite;

    public CaffeineCacheConfig(
            @Value("${cache.caffeine.initialCapacity:100}") int initialCapacity,
            @Value("${cache.caffeine.maximumSize:1000000}") long maximumSize,
            @Value("${cache.caffeine.expireAfterAccess:60}") int expireAfterAccess,
            @Value("${cache.caffeine.expireAfterWrite:60}") int expireAfterWrite,
            @Value("${cache.caffeine.refreshAfterWrite:60}") int refreshAfterWrite
    ) {
        this.initialCapacity = initialCapacity;
        this.maximumSize = maximumSize;
        this.expireAfterAccess = expireAfterAccess;
        this.expireAfterWrite = expireAfterWrite;
        this.refreshAfterWrite = refreshAfterWrite;
    }

    @Bean(name = "caffeineCacheManager")
    @Primary
    public CacheManager caffeineConfig() {
        Caffeine<Object, Object> objectObjectCaffeine = Caffeine.newBuilder()
                .initialCapacity(initialCapacity)
                .maximumSize(maximumSize)
                .expireAfterWrite(expireAfterWrite, TimeUnit.SECONDS);

        var manager = new CaffeineCacheManager();
        manager.setCaffeine(objectObjectCaffeine);
        return manager;
    }
}
