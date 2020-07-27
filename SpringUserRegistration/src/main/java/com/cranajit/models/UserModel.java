package com.cranajit.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="springUser")
public class UserModel {

    @Column(name="gender")
    private String gender;

    public UserModel(String gender) {
        this.gender = gender;
    }

    public UserModel() {
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "gender='" + gender + '\'' +
                '}';
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
