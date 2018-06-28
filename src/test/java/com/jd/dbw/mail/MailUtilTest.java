package com.jd.dbw.mail;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import static org.junit.Assert.*;

public class MailUtilTest {

    @Test
    public void send() {
        MailUtil.send();
    }

}