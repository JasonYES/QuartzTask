package com.jd.dbw.dao;

import com.jd.dbw.mail.MailUtil;

import java.io.InputStream;
import java.util.Properties;

public class ProLoader {
    public static Properties load() {
        Properties pro = new Properties();
        try (InputStream input = MailUtil.class.getClassLoader().getResourceAsStream("main.properties")){
            pro.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pro;
    }
}
