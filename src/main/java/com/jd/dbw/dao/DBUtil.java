package com.jd.dbw.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

class DBUtil {


    static int count(String table) {

        String sql = "SELECT COUNT(*) AS total FROM " + table;

        try (Connection conn = DBUtil.connect();
             Statement s = conn.createStatement();
             ResultSet rs = s.executeQuery(sql)) {

            rs.next();
            return rs.getInt("total");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    static List<String> countTables(String db) {

        List<String> tables = new ArrayList<>();
        ResultSet rs = null;

        try (Connection conn = DBUtil.connect();
             Statement s = conn.createStatement()) {

            s.execute("use " + db);
            rs = s.executeQuery("show tables");

            while (rs.next()) {
                tables.add("`" + db + "`.`" + rs.getString(1) + "`");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return tables;
    }

    static Connection connect() throws SQLException {

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
