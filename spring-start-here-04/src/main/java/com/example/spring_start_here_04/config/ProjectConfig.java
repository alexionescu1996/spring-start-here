package com.example.spring_start_here_04.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ProjectConfig {

    @Value("${custom.datasource.url}")
    private String url;

    @Value("${custom.datasource.username}")
    private String username;

    @Value("${custom.datasource.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setConnectionTimeout(1_000);

        return dataSource;
    }
}
