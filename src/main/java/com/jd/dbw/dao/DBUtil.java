package com.jd.dbw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

    public static Connection connect() throws SQLException {

        Properties pro = ProLoader.load();
        String JDBC_DRIVER = pro.getProperty("db.driver-class-name");
        String DB_URL = pro.getProperty("db.url");
        String USER = pro.getProperty("db.username");
        String PASS = pro.getProperty("db.password");

        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(DB_URL, USER, PASS);

    }

}
