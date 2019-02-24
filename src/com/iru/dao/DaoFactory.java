package com.iru.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DaoFactory {
    private static String url;
    private static String user;
    private static String password;

    public Connection getConnection() {
        if (url == null || user == null || password == null) {
            Properties properties = new Properties();
            try {
                properties.load(new FileInputStream("resources/db/db.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            url = properties.getProperty("url");
            user = properties.getProperty("username");
            password = properties.getProperty("password");
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
