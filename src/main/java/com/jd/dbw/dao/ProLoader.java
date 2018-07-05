package com.jd.dbw.dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ProLoader {

    private static Properties properties = new Properties();
    private static String location = null;

    public static void setLocation(String location) {
        ProLoader.location = location;
    }

    public static void init() {
        if (location == null) {
            try (InputStream input = ProLoader.class.getClassLoader().getResourceAsStream("main.properties")) {
                properties.load(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try (
                    InputStreamReader input = new InputStreamReader(new FileInputStream(location), "UTF-8")
            ) {
                properties.load(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Properties getProperties() {
        if (properties.size() == 0) {
            init();
        }
        return properties;
    }

}
