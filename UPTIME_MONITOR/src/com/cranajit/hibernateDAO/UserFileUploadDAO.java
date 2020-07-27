package com.cranajit.hibernateDAO;

import com.cranajit.entityclasses.UserFileUpload;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserFileUploadDAO {
    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(UserFileUpload.class)
            .buildSessionFactory();

    public void insertUploadedFileDetails(UserFileUpload file) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(file);
        session.getTransaction().commit();
        System.out.println(file.getName()+" is added into the database");
    }

    public void GetAllOfTheFileNames(UserFileUpload file) {

    }
}
