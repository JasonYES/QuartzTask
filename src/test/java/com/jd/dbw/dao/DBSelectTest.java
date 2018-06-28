package com.jd.dbw.dao;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class DBSelectTest {

    @Test
    public void count() {
        assertTrue(new DBSelector().count() > 0);
    }
}