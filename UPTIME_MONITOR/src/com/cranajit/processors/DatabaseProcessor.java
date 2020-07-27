package com.cranajit.processors;

import com.cranajit.models.UserInfoModel;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseProcessor {

    public static int insertUserInfo(UserInfoModel model, DataSource dataSource) {
        Connection connection;
        PreparedStatement statement;
        int rowAffected = 0;
        try {
            connection = dataSource.getConnection();
            String query = "INSERT INTO user_info VALUES(?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, model.getPhone());
            statement.setString(2, model.getFirstName());
            statement.setString(3, model.getLastName());
            statement.setString(4, model.getPassword());
            statement.setString(5, model.getGender());
            statement.setString(6, model.getLanguage());
            statement.setString(7, model.getCountry());
            rowAffected = statement.executeUpdate();
            connection.close();
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
        return rowAffected;
    }

    public static String loginUserInfo(String phone, DataSource dataSource) {
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        String password = "";
        try {
            connection = dataSource.getConnection();
            String query = "SELECT password FROM user_info WHERE phone=?";
            statement = connection.prepareStatement(query);
            statement.setString(1, phone);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                password = resultSet.getString("password");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return password;
    }

    public static List<UserInfoModel> getAllMembersInfo(DataSource dataSource) {
        Connection connection;
        Statement statement;
        ResultSet resultSet;
        List<UserInfoModel> userData = new ArrayList<>();
        try {
            connection = dataSource.getConnection();
            String query = "SELECT * FROM user_info";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                userData.add(new UserInfoModel(resultSet.getString("phone"),
                        resultSet.getString("firstName"), resultSet.getString("lastName"),
                        resultSet.getString("password"), resultSet.getString("gender"),
                        resultSet.getString("languages"), resultSet.getString("country")));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userData;
    }

    public static int updateUserInfo(DataSource dataSource, UserInfoModel model, String phone) {
        Connection connection;
        PreparedStatement statement;
        try {
            connection = dataSource.getConnection();
            String query = "UPDATE user_info SET firstName=?, lastName=?, " +
                    "password=?, gender=?, languages=?, country=? WHERE phone=?";
            statement = connection.prepareStatement(query);
            statement.setString(1, model.getFirstName());
            statement.setString(2, model.getLastName());
            statement.setString(3, model.getPassword());
            statement.setString(4, model.getGender());
            statement.setString(5, model.getLanguage());
            statement.setString(6, model.getCountry());
            statement.setString(7, phone);
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static UserInfoModel getUserInfo(String phone, DataSource dataSource) {
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        String password = "";
        UserInfoModel user= null;
        try {
            connection = dataSource.getConnection();
            String query = "SELECT * FROM user_info WHERE phone=?";
            statement = connection.prepareStatement(query);
            statement.setString(1, phone);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                user = new UserInfoModel(phone, resultSet.getString("firstName"),
                        resultSet.getString("lastName"), resultSet.getString("password"),
                        resultSet.getString("gender"), resultSet.getString("languages"),
                        resultSet.getString("country"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static int deleteUser(DataSource dataSource, String phone) {
        Connection connection;
        PreparedStatement statement;

        try {
            connection = dataSource.getConnection();
            String query = "DELETE FROM user_info WHERE phone=?";
            statement = connection.prepareStatement(query);
            statement.setString(1, phone);
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
