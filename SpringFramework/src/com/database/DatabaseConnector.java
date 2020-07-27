package com.database;

import org.springframework.beans.factory.annotation.Value;

import java.sql.*;

public class DatabaseConnector {
    @Value("${database.driver}")
    private String driverClassName;

    @Value("${database.url}")
    private String url;

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

    @Override
    public String toString() {
        return "DatabaseConnector{" +
                "driverClassName='" + driverClassName + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void connect() throws SQLException, ClassNotFoundException {
        Class.forName(driverClassName);
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connection created : "+connection);
        String query = "SELECT * FROM users;";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(query);
    }
}
