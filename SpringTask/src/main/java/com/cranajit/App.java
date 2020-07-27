package com.cranajit;

import com.cranajit.interfaces.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Car myCar = context.getBean("bmw", Car.class);
        System.out.println(myCar.getName());
    }
}
