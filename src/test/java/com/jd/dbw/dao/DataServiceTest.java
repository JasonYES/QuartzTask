package com.jd.dbw.dao;

import org.junit.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class DataServiceTest {

    @Test
    public void getTableData() throws SQLException {

        Connection connection = Mockito.mock(Connection.class);


        connection.close();


        System.out.println(DataService.getTableData());
    }
}