package com.IOC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("studentBeans.xml");
        Student s1 = context.getBean("student", Student.class);
        System.out.println(s1.toString());
        s1.currentlyReading();

        Student s2 = context.getBean("student2", Student.class);
        System.out.println(s2.toString());
        s2.currentlyReading();

        Student s3 = context.getBean("student3", Student.class);
        System.out.println(s3.toString());
        s3.currentlyReading();

        Student s4 = context.getBean("student4", Student.class);
        System.out.println(s4.toString());
        s4.currentlyReading();
    }
}
