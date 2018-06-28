package com.jd.dbw.dao;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ProLoaderTest {

    @Test
    public void load() {
        assertTrue(ProLoader.load().size() == 10);
    }

}