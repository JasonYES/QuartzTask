package com.jd.dbw.dao;

import java.util.*;

public class DataService {
    public static Map<String, Integer> getTableData() {
        Properties pro = ProLoader.getProperties();
        String tables =pro.getProperty("db.tables");

        String[] ts = tables.split(",");
        Map<String, Integer> res = new HashMap<>();

        for (String t : ts) {
            int value = DBUtil.count(t);
            res.put(t, value);
        }
        return res;
    }
}
