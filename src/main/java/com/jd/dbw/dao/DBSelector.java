package com.jd.dbw.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBSelector {

    public int count() {

        String sql;
        sql = "SELECT COUNT(*) AS total FROM city";

        try (Connection conn = DBUtil.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            rs.next();

            return rs.getInt("total");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
