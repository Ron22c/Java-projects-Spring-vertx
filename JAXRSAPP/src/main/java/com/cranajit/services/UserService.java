package com.cranajit.services;

import com.cranajit.daoclasses.UserDAO;
import com.cranajit.entiyclasses.UserModel;
import java.util.List;

public class UserService {
    UserDAO userDAO = new UserDAO();

    public List<UserModel> getUsers() {
        List<UserModel> userData = userDAO.getUserData();
        return userData;
    }

    public List<UserModel> getUserByGender(String gender) {
        return userDAO.getUserDataByGender(gender);
    }

    public UserModel addUserData(UserModel model) {
        UserModel addedModel = userDAO.addUserData(model);
        return addedModel;
    }

    public UserModel updateUserData(UserModel updatedUser) {
        UserModel userData = userDAO.updateUserData(updatedUser);
        return userData;
    }

    public void deleteUser(String phone) {
        userDAO.deleteUser(phone);
    }
}
