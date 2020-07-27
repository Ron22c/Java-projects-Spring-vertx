package com.cranajit.models;

import javax.validation.constraints.Size;
import java.util.Arrays;

public class UserModel {
    @Size(max = 10, min = 5)
    String name;
    String email;
    String gender;
    String country;
    String introduction;
    String[] languages;

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", country='" + country + '\'' +
                ", introduction='" + introduction + '\'' +
                ", languages=" + Arrays.toString(languages) +
                '}';
    }
}
