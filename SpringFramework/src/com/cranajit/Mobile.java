package com.cranajit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mobile {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("Objects are created");

        Sim sim = context.getBean("sim", Sim.class);
        sim.calling();
        sim.data();


        Student student1 = context.getBean("student1", Student.class);
        student1.display();
        student1.currentlyReading();

        Student student2 = context.getBean("student2", Student.class);
        student2.display();
        student2.currentlyReading();
    }
}
