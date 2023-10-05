package com.example.searchbycriteriaexample.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class DbProperties {
    private String driverClassName;
    private String url;
    private String host;
    private String username;
    private String password;
    private Integer port;
    private String baselineOnMigrate;

    public DbProperties() {
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getBaselineOnMigrate() {
        return baselineOnMigrate;
    }

    public void setBaselineOnMigrate(String baselineOnMigrate) {
        this.baselineOnMigrate = baselineOnMigrate;
    }
}
