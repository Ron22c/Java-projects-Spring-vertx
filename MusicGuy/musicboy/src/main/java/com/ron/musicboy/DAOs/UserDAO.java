package com.ron.musicboy.DAOs;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ron.musicboy.models.UserModel;

public class UserDAO {
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(UserModel.class)
			.buildSessionFactory();
	

	public UserModel createUser(UserModel model) {
    	Session session = factory.getCurrentSession();
    	session.beginTransaction();
    	session.save(model);
    	session.getTransaction().commit();
		return model;
	}
	
	public UserModel getUser(String phone) {
    	Session session = factory.getCurrentSession();
    	session.beginTransaction();
    	UserModel user = null;
		try {
			user= (UserModel)session.createQuery("FROM users WHERE phone= '"+phone+"'").getSingleResult();
		} catch (NoResultException e) {
			session.getTransaction().commit();
			return null;
		}
		return user;
	}
}
