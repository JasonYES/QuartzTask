package com.jd.dbw.dao;

import com.google.common.base.Joiner;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DataService {

    public static Map<String, Integer> getTableData() {
        Properties pro = ProLoader.getProperties();
        String db = pro.getProperty("db.db");
        String tables = null;

        if (db == null || db.equals("") || db.equals(" ")) {

            tables = pro.getProperty("db.tables");

        } else {
            tables = Joiner.on(",").join(DBUtil.countTables(db));
        }

        String[] ts = tables.split(",");
        Map<String, Integer> res = new HashMap<>();

        for (String t : ts) {
            int value = DBUtil.count(t);
            res.put(t, value);
        }
        return res;
    }
}
