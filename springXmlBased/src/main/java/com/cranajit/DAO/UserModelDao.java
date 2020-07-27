package com.cranajit.DAO;

import com.cranajit.models.UserModel;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class UserModelDao {
    private DataSource dataSource;

    public UserModelDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void registerUser(UserModel model) {
        try {
            String query = "INSERT INTO user_info VALUES (?, ?, ?, ?, ?, ?, ?);";
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, model.getPhone());
            statement.setString(2, model.getFirstName());
            statement.setString(3, model.getLastName());
            statement.setString(4, model.getPassword());
            statement.setString(5, model.getGender());
            statement.setString(6, Arrays.toString(model.getLanguage()));
            statement.setString(7, model.getCountry());

            statement.executeUpdate();
            System.out.println("DATA UPDATED");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
