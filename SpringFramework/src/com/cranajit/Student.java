package com.cranajit;

public class Student {
    private int id;
    private String name;
    private Book book;

    public Student() {
    }

    public Student(int id) {
        this.id = id;
    }

    public Student(int id, String name, Book book) {
        this.id = id;
        this.name = name;
        this.book = book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void display() {
        System.out.println("Student name is: "+name+" and id is: "+id);
    }

    public void currentlyReading() {
        book.read();
    }
}
