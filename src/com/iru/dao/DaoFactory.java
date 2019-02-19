package com.iru.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DaoFactory {
    private static final String PROPERTY_URL = "url";
    private static final String PROPERTY_DRIVER = "driver";
    private static final String PROPERTY_USERNAME = "username";
    private static final String PROPERTY_PASSWORD = "password";

    public Connection getConnection(){
        /*try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        Properties properties = new Properties();
        Path currentPath = Paths.get("");
        String s = currentPath.toAbsolutePath().toString();
        try {
            properties.load(new FileInputStream(s+"\\resources\\db.properties"));//D:\draft_uni\resources
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = properties.getProperty("url");
        String user = properties.getProperty("username");
        String password = properties.getProperty("password");
//        String url = "jdbc:postgresql://localhost:5432/university";
//        String user = "postgres";
//        String password = "0000";



//        System.out.println("Current relative path is: " + s);

        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;

    }
}
