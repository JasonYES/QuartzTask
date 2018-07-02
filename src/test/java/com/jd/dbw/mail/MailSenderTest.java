package com.jd.dbw.mail;

import org.junit.Test;

import static org.junit.Assert.*;

public class MailSenderTest {

    @Test
    public void sendMessage() {
        MailSender ms = new MailSender();
        ms.sendMessage();
    }
}