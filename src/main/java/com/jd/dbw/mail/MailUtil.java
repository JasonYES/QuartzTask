package com.jd.dbw.mail;

//import com.jd.dbw.dao.DBSelector;
import com.jd.dbw.dao.ProLoader;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.util.Properties;

@Deprecated
public class MailUtil {

    public static void send() {

        Properties pro = ProLoader.getProperties();
        String hostname = pro.getProperty("mail.hostname");
        String to = pro.getProperty("mail.to");
        String from = pro.getProperty("mail.from");
        String from_name = pro.getProperty("mail.from_name");
        String password = pro.getProperty("mail.password");
        String subject = pro.getProperty("mail.subject");

        HtmlEmail email = new HtmlEmail();
        try {
            // 这里是SMTP发送服务器的名字：qq的如下：
            email.setHostName(hostname);
            // 字符编码集的设置
            email.setCharset("utf-8");
            // 收件人的邮箱
            email.addTo(to);
            // 发送人的邮箱
            email.setFrom(from, from_name);
            // 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码
            email.setAuthentication(from, password);
            email.setSubject(subject);
            // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签

            //邮件内容的拼接
            StringBuilder sb = new StringBuilder();
//            sb.append("<h1>数据库实时记录条数：" + new DBSelector().count("city") + "</h1>");

            email.setHtmlMsg(sb.toString());
            // 发送
            email.send();

            System.out.println();
            System.out.println("success!");
            System.out.println();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

}
