package com.jd.dbw.utils;

import java.io.Serializable;

/**
 * Created by wuzhengxuan on 2017/10/20.
 */
public class EmailMessage implements Serializable {

    private String to;
    private String text;
    private String subject;
    private String sys_idx;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSys_idx() {
        return sys_idx;
    }

    public void setSys_idx(String sys_idx) {
        this.sys_idx = sys_idx;
    }
}
