package com.iru.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DaoFactory {
    private static Properties properties;

    public Connection getConnection() {
        if (properties == null) {
            checkProperties();
        }
        Connection connection = null;
        try {
            connection =
                    DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private boolean checkProperties() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("resources/db/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
