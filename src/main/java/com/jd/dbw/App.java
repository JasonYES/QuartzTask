package com.jd.dbw;

import com.jd.dbw.dao.ProLoader;
import com.jd.dbw.timer.QuartzTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Enumeration;
import java.util.Properties;

public class App {

    private final static Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        if (args.length >= 1) {
            String properties_address = args[0];
            ProLoader.setLocation(properties_address);
        }

        Properties show = ProLoader.getProperties();
        Enumeration en = show.propertyNames();
        LOGGER.info("--------------------PROPERTIES-------------------");
        while (en.hasMoreElements()) {
            String element = en.nextElement().toString();
            LOGGER.info(element + "=" + ProLoader.getProperties().getProperty(element));
        }
        LOGGER.info("--------------------PROPERTIES-------------------");

        QuartzTask.run();

    }

}