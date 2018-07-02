package com.jd.dbw.mail;

//import com.jd.dbw.dao.DBSelector;
import com.jd.dbw.dao.ProLoader;
import com.jd.dbw.utils.SendEmailService;
import com.jd.dbw.view.VeloDrawer;

import java.util.Properties;

public class MailSender {
    public void sendMessage() {

        SendEmailService ses = new SendEmailService();

        String mail = VeloDrawer.draw();

        Properties pro = ProLoader.getProperties();
        String subject = pro.getProperty("mail.subject");
        String target = pro.getProperty("mail.target");
        ses.sendMessage(target, subject, mail);
    }
}
