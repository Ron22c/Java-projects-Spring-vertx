package com.cranajit.daoclasses;

import com.cranajit.models.UserModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserDAO {
    private SessionFactory factory = new Configuration()
            .configure("/hibernate.cfg.xml")
            .addAnnotatedClass(UserModel.class)
            .buildSessionFactory();

    public void addUserInfo(UserModel model) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(model);
        session.getTransaction().commit();
        System.out.println("Added rechord successfully");
    }
}
