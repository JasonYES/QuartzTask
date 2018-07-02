package com.jd.dbw.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * Created by njwangxi@jd.com on 2016/11/7.
 */
public class JsonUtils {

    /**
     * object to string
     * @param o
     * @return
     */
    public static final String toJsonString(Object o){
        return JSON.toJSONString(o) ;
    }

    /**
     * string to object
     */
    public static final JSONObject toObject(String json){
        return JSON.parseObject(json) ;
    }

    /**
     * string to array
     */
    public static final JSONArray toArray(String json){
        return JSON.parseArray(json) ;
    }

    /**
     * string to java object
     */
    public static final <T> T toJavaObject(String json,Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    /**
     * json string to map
     * @param json
     * @return
     */
    public static final Map<String,Object> toMap(String json){
        return toJavaObject(json,Map.class) ;
    }

}
