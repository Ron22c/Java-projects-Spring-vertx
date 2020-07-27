package com.cranajit;

import com.cranajit.interfaces.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Car mycar = context.getBean("ferrari", Car.class);
        System.out.println(mycar.specs());
        context.close();
    }
}
