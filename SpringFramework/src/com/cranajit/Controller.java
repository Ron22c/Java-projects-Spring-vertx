package com.cranajit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Controller {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("controlBeans.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user.toString());

        User second = (User)context.getBean("second");
        System.out.println(second.toString());
    }
}
