package com.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class College {
    private String collegeName;
    private CollegeStudent student;
    private Teacher teacher;

    public College() {
    }

    public College(String collegeName, CollegeStudent student, Teacher teacher) {
        this.collegeName = collegeName;
        this.student = student;
        this.teacher = teacher;
    }

    @Value("${college.name}")
    @Required
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    @Autowired
    public void setStudent(CollegeStudent student) {
        this.student = student;
    }

    @Autowired
    @Qualifier("math")
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void call() {
        System.out.println("This is a college and name is "+collegeName);
        teacher.teach();
        student.displayInfo();
    }
}
