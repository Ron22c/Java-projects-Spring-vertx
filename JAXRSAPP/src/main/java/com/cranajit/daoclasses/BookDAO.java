package com.cranajit.daoclasses;

import com.cranajit.entiyclasses.BooksModel;
import com.cranajit.entiyclasses.UserModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class BookDAO {
    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(BooksModel.class)
            .addAnnotatedClass(UserModel.class)
            .buildSessionFactory();
    public List<BooksModel> getBooks(String phone) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<BooksModel> books = session.createQuery("FROM user_books WHERE phone='"+phone+"'").getResultList();
        session.getTransaction().commit();
        return books;
    }
}
