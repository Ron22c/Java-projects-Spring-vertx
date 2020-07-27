package com.cranajit.config;

import com.cranajit.DAO.UserModelDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfig {

    @Bean
    public DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/JAVA_DB ");
        dataSource.setUsername("root");
        dataSource.setPassword("Summerof@69");
        return dataSource;
    }

    @Bean(name = "daoClass")
    public UserModelDAO getDaoClass() {
        return new UserModelDAO(getDataSource());
    }
}
