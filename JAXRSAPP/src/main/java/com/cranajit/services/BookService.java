package com.cranajit.services;

import com.cranajit.daoclasses.BookDAO;
import com.cranajit.entiyclasses.BooksModel;
import java.util.List;

public class BookService {
    BookDAO bookDAO = new BookDAO();

    public List<BooksModel> getBooks(String phone) {
        List<BooksModel> books = bookDAO.getBooks(phone);
        return books;
    }
}
