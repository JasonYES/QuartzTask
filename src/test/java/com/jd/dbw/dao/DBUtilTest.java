package com.jd.dbw.dao;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import static org.junit.Assert.*;

public class DBUtilTest {

    @Test
    public void connect() {
        try (Connection conn = DBUtil.connect()){
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}