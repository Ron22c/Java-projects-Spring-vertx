package com.cranajit.daoclasses;

import com.cranajit.entiyclasses.UserModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserDAO {
    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(UserModel.class)
            .buildSessionFactory();

    public List<UserModel> getUserData() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<UserModel> userData = session.createQuery("FROM user_info").getResultList();
        session.getTransaction().commit();
        return userData;
    }

    public List<UserModel> getUserDataByGender(String gender) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<UserModel> userdata = session.createQuery("FROM user_info WHERE gender='"+gender+"'").getResultList();
        session.getTransaction().commit();
        return userdata;
    }

    public UserModel addUserData(UserModel model) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(model);
        session.getTransaction().commit();
        return model;
    }

    public UserModel updateUserData(UserModel updatedUser) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        UserModel model = session.get(UserModel.class, updatedUser.getPhone());
        if(updatedUser.getCountry()!=null) model.setCountry(updatedUser.getCountry());
        if(updatedUser.getFirstName()!=null) model.setFirstName(updatedUser.getFirstName());
        if(updatedUser.getLastName()!=null) model.setLastName(updatedUser.getLastName());
        if(updatedUser.getGender()!=null) model.setGender(updatedUser.getGender());
        if(updatedUser.getLanguages()!=null) model.setLanguages(updatedUser.getLanguages());
        session.getTransaction().commit();
        return model;
    }

    public void deleteUser(String phone) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        UserModel model = session.get(UserModel.class, phone);
        session.delete(model);
        session.getTransaction().commit();
    }
}
