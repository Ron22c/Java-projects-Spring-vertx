package com.cranajit.entiyclasses;

import javax.persistence.*;

//@XmlRootElement
@Entity(name="user_info")
@Table(name = "user_info")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone")
    private String phone;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    private String gender;

    @Column(name = "languages")
    private String languages;

    @Column(name = "country")
    private String country;

    public UserModel() {
    }

    public UserModel(String phone, String firstName, String lastName,
                     String password, String gender,
                     String languages, String country) {
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.gender = gender;
        this.languages = languages;
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

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
