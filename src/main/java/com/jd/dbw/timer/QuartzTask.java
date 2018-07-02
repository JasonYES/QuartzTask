package com.jd.dbw.timer;

import com.jd.dbw.dao.ProLoader;
import org.apache.log4j.BasicConfigurator;
import org.quartz.*;

import java.util.TimeZone;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class QuartzTask {

    public static void run() {
        BasicConfigurator.configure();

        String cron = ProLoader.getProperties().getProperty("quartz.cron");

        try {
            // Grab the Scheduler instance from the Factory
            SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
            Scheduler sched = schedFact.getScheduler();
            sched.start();


            JobDetail job = newJob(WatchJob.class)
                    .withIdentity("myJob", "group1")
                    .build();

            Trigger trigger = newTrigger()
                    .withIdentity("trigger", "group1")
                    .withSchedule(cronSchedule(cron).inTimeZone(TimeZone.getTimeZone("Asia/Shanghai")))
                    .forJob("myJob", "group1")
                    .build();

            sched.scheduleJob(job, trigger);

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }

}
