package com.jd.dbw.dao;

import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

public class ProLoaderTest {

    @Test
    public void setLocation() {
    }

    @Test
    public void init() {
    }

    @Test
    public void getProperties() {
        assertTrue(ProLoader.getProperties().getProperty("quartz.cron") != null);
    }
}