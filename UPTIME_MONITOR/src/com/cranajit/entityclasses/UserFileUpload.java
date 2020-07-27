package com.cranajit.entityclasses;

/**
 * create table query:
 * create table user_file_upload (phone varchar(15) primary key, name varchar(45), description varchar(45));
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "user_file_upload")
@Table(name="user_file_upload")
public class UserFileUpload {
    @Id
    @Column(name = "phone")
    private String phone;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public UserFileUpload(String phone, String name, String description) {
        this.phone = phone;
        this.name = name;
        this.description = description;
    }
    public UserFileUpload() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UserFileUpload{" +
                "phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
