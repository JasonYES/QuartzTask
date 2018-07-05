package com.jd.dbw.timer;

import com.jd.dbw.mail.MailSender;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class WatchJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {

        MailSender mailSender = new MailSender();
        mailSender.sendMessage();

    }
}
