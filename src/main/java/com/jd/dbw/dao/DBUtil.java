package com.jd.dbw.dao;

import java.sql.*;
import java.util.Properties;

public class DBUtil {

    public static int count(String table) {

        String sql;
        sql = "SELECT COUNT(*) AS total FROM " + table;

        try (Connection conn = DBUtil.connect();
             Statement s = conn.createStatement();
             ResultSet rs = s.executeQuery(sql)) {

            rs.next();
            return rs.getInt("total");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static Connection connect() throws SQLException {

        Properties pro = ProLoader.getProperties();
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
