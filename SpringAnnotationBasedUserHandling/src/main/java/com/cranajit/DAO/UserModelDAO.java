package com.cranajit.DAO;

import com.cranajit.models.UserModel;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserModelDAO {
    private DataSource dataSource;

    public UserModelDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addUser(UserModel model) {
        try {
            String query = "INSERT INTO user_info VALUES (?, ?, ?, ?, ?, ?, ?)";
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

    public List<UserModel> getAllUser() {
        List<UserModel> users = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            String query = "SELECT * FROM user_info;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                List<String> items = Arrays.asList(resultSet.getString("languages").split("\\s*,\\s*"));

                String[] languages = new String[items.size()];
                for(int i=0; i<items.size(); i++) {
                    languages[i]=items.get(i);
                }

                users.add(new UserModel(resultSet.getString("phone"),
                        resultSet.getString("firstName"), resultSet.getString("lastName"),
                        resultSet.getString("password"), resultSet.getString("gender"),
                        languages, resultSet.getString("country")));
                System.out.println("USER ADDED INTO THE LIST");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }
}
