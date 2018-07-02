package com.jd.dbw;

import com.jd.dbw.dao.ProLoader;
import com.jd.dbw.timer.QuartzTask;

public class App {
    public static void main(String[] args) {
        if (args.length > 1) {
            String properties_address = args[1];
            ProLoader.setLocation(properties_address);
        }
        QuartzTask.run();
    }
}