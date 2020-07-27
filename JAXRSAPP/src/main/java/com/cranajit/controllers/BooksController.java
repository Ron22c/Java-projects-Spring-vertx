package com.cranajit.controllers;

import com.cranajit.entiyclasses.BooksModel;
import com.cranajit.services.BookService;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class BooksController {
    BookService bookService = new BookService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BooksModel> getBookByUser(@PathParam("phone") String phone) {
        List<BooksModel> books = bookService.getBooks(phone);
        return books;
    }
}
