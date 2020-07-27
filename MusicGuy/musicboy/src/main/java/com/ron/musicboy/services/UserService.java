package com.ron.musicboy.services;

import com.ron.musicboy.DAOs.UserDAO;
import com.ron.musicboy.models.UserModel;

public class UserService {
	UserDAO userdao = new UserDAO();

	public UserModel createUser(UserModel model) {
		if (userdao.getUser(model.getPhone()) != null) {
			return null;
		}
		String password = model.getPassword();
		
		UserModel user = userdao.createUser(model);
		return user;
	}
	
	public UserModel getUser(String phone) {
		UserModel user = userdao.getUser(phone);
		return user;
	}
}
