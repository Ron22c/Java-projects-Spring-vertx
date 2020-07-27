package com.lifeCycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.sql.SQLException;

public class Client {
    public static void main(String[] args) throws SQLException {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        context.registerShutdownHook();

        UserDAO dao = context.getBean("dao", UserDAO.class);
        dao.showAllRows();
//        dao.addUser(5, "chandra", "abc@qwe.com");
//        dao.deleteUser(3);
    }
}
