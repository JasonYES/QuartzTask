package com.jd.dbw.timer;

import org.apache.log4j.BasicConfigurator;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;

public class QuartzTask {

    public static void run() {
        BasicConfigurator.configure();

        try {
            // Grab the Scheduler instance from the Factory
            SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
            Scheduler sched = schedFact.getScheduler();
            sched.start();

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }

}
