package com.cranajit.daoclasses;

import com.cranajit.models.UserModel;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoDS {
    private DataSource dataSource;

    public UserDaoDS(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setGender(UserModel model) {
        String query = "update user_info set gender=? where phone=?";
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, model.getGender());
            statement.setString(2,"9874791749");
            statement.executeUpdate();
            System.out.println("UPDATED GENDER");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
