package com.jd.dbw.dao;

import com.jd.dbw.mail.MailUtil;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ProLoader {

    private static Properties properties = new Properties();
    private static String location = null;

    public static void setLocation(String location) {
        ProLoader.location = location;
    }

    public static void init() {
        if (location == null) {
            try (InputStream input = ProLoader.class.getClassLoader().getResourceAsStream("main.properties")){
                properties.load(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try (InputStream input = new FileInputStream(location)){
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
        return new Properties(properties);
    }

//    @Deprecated
//    public static Properties load() {
//        Properties pro = new Properties();
//
//        try (InputStream input = ProLoader.class.getClassLoader().getResourceAsStream("main.properties")){
//            pro.load(input);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return pro;
//    }
}
