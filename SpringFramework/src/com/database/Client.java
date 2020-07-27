package com.database;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("databasebeans.xml");
        DatabaseConnector connector = context.getBean("database", DatabaseConnector.class);
        try {
            connector.connect();
            System.out.println(connector);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

