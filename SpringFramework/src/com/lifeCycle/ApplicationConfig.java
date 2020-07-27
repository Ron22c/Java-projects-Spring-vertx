package com.lifeCycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.lifeCycle")
@PropertySource(value = "classpath:databaseinfo.properties")
public class ApplicationConfig {

    @Bean(name = "dao")
    public UserDAO getDaoBean() {
        UserDAO dao = new UserDAO();
        dao.setDriver("com.mysql.cj.jdbc.Driver");
        dao.setUrl("jdbc:mysql://localhost:3306/JAVA_DB");
        dao.setUsername("root");
        dao.setPassword("Summerof@69");
        return dao;
    }
}
