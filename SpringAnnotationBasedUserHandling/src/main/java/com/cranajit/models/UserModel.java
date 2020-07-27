package com.cranajit.models;

import java.util.Arrays;

public class UserModel {
    private String phone;
    private String firstName;
    private String lastName;
    private String password;
    private String gender;
    private String[] language;
    private String country;

    public UserModel() {
    }

    public UserModel(String phone, String firstName, String lastName, String password, String gender, String[] language, String country) {
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.gender = gender;
        this.language = language;
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getLanguage() {
        return language;
    }

    public void setLanguage(String[] language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "phone='" + phone + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", language=" + Arrays.toString(language) +
                ", country='" + country + '\'' +
                '}';
    }
}
