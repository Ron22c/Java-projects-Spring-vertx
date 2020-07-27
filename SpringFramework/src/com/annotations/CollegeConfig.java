package com.annotations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.annotations"})
@PropertySource(value = "classpath:college.properties")
public class CollegeConfig {

/*    @Bean("student")
    public CollegeStudent getStudentBean() {
        CollegeStudent student = new CollegeStudent();
        student.setName("Ranajit");
        student.setRoll(23);
        return student;
    }

    @Bean
    public Teacher getMathTeacher() {
        return new Math();
    }

    @Bean
    public Teacher getScienceTeacher() {
        return new Science();
    }

    @Bean("college")
    public College getCollegeBean() {
        College c =  new College();
        c.setStudent(getStudentBean());
        c.setCollegeName("PCMT");
        c.setTeacher(getMathTeacher());
        return c;
    }

 */
}
