package com.jd.dbw.timer;

import com.jd.dbw.mail.MailUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class WatchJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {

        MailUtil.send();

    }
}
