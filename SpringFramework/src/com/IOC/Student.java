package com.IOC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Student {
    private String name;
    private String email;
    private Book book;

    public Student() {
    }

    public Student(String name, String email, Book book) {
        System.out.println("Constructor");
        this.name = name;
        this.email = email;
        this.book = book;
    }

    public Student(Book book) {
        System.out.println("Constructor");
        this.book = book;
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

    public Book getBook() {
        return book;
    }


    @Autowired
    @Qualifier("scienceBook")
    public void setBook(Book book) {
        System.out.println("setter method");
        this.book = book;
    }

    public void currentlyReading() {
        book.bookName();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", book=" + book +
                '}';
    }
}
