package com.jd.dbw;

import com.jd.dbw.timer.QuartzTask;

public class App {
    public static void main(String[] args) {
        QuartzTask.run();
    }
}