package com.cranajit.entiyclasses;

import javax.persistence.*;

/**
    CREATE TABLE user_books (
    phone varchar(15) NOT NULL,
    book_id int AUTO_INCREMENT,
    book_name varchar(15),
    book_pages int,
    PRIMARY KEY (book_id),
    FOREIGN KEY (phone) REFERENCES user_info(phone));

    INSERT INTO user_books (phone, book_name, book_pages)
    VALUES('07980705729', 'A Book', 200);
*/

@Entity(name = "user_books")
@Table(name = "user_books")
public class BooksModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;

    @ManyToOne(targetEntity = UserModel.class)
    @JoinColumn(name = "phone")
    UserModel user;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_pages")
    private int bookPages;

    public BooksModel() {
    }

    public BooksModel(UserModel user, String bookName, int bookPages) {
        this.user = user;
        this.bookName = bookName;
        this.bookPages = bookPages;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookPages() {
        return bookPages;
    }

    public void setBookPages(int bookPages) {
        this.bookPages = bookPages;
    }
}
