package com.lifeCycle;

import org.springframework.beans.factory.annotation.Required;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;

public class UserDAO {
    private String driver;
    private String url;
    private String username;
    private String password;
    private Connection connection;

    //@Value("${database.driver}")
    public void setDriver(String driver) {
        System.out.println("driver CALLED");
        this.driver = driver;
    }

    //@Value("${database.url}")
    @Required
    public void setUrl(String url) {
        System.out.println("url CALLED");
        this.url = url;
    }

    //@Value("${database.username}")
    @Required
    public void setUsername(String username) {
        System.out.println("username CALLED");
        this.username = username;
    }

    //@Value("${database.password}")
    @Required
    public void setPassword(String password) {
        System.out.println("password CALLED");
        this.password = password;
    }

    @PostConstruct
    public void init() throws SQLException, ClassNotFoundException {
        System.out.println("INIT CALLED");
        createConnection();
    }

    public void createConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, username, password);
    }

    public void showAllRows() throws SQLException {
        String query = "SELECT * from Users";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()) {
            int userId = resultSet.getInt("user_id");
            String userName = resultSet.getString("user_name");
            String email = resultSet.getString("email");
            System.out.println(userId+ " "+userName+" "+email);
        }
    }

    public void deleteUser(int userId) throws SQLException {
        String query = "DELETE FROM users WHERE user_id="+userId;
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        System.out.println("DELETED USER: "+userId);
    }

    public void addUser(int userId, String userName, String email) throws SQLException {
        String query = "INSERT INTO users VALUES ('"+userId+"','"+userName+"','"+email+"');";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        System.out.println("UPDATED USER: "+userId);
    }

    @PreDestroy
    public void destroy() throws SQLException {
        System.out.println("DESTROY CALLED");
        connection.close();
    }
}
