package com.jd.dbw.dao;

import org.junit.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class DataServiceTest {

    @Test
    public void getTableData() throws SQLException {

        System.out.println(DataService.getTableData());

    }
}