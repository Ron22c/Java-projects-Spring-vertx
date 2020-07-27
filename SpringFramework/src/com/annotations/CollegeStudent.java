package com.annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CollegeStudent {
    private String name;
    private int roll;

    public CollegeStudent(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }

    public CollegeStudent() {
    }

    @Value("${college.student.name}")
    public void setName(String name) {
        this.name = name;
    }

    @Value("${college.student.roll}")
    public void setRoll(int roll) {
        this.roll = roll;
    }

    public void displayInfo() {
        System.out.println( "CollegeStudent{" +
                "name='" + name + '\'' +
                ", roll=" + roll +
                '}');
    }
}
