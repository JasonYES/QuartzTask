package com.jd.dbw.utils;

/**
 * Created by PL-pc on 2016/11/2.
 */

import com.alibaba.druid.support.json.JSONUtils;
import com.github.kevinsawicki.http.HttpRequest;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class HttpUtils {

    private static final Logger logger = Logger.getLogger(HttpUtils.class) ;

    public static Map<String, Object> request(String url, String action, String host) {
        HttpRequest request = null;

        if (action.equalsIgnoreCase("get")) {
            request = HttpRequest.get(url, true);
        } else if (action.equalsIgnoreCase("post")) {
            request = HttpRequest.post(url, true);
        } else if (action.equalsIgnoreCase("delete")) {
            request = HttpRequest.delete(url, true);
        } else if (action.equalsIgnoreCase("put")) {
            request = HttpRequest.put(url, true);
        }

        request.header("Content-type", "application/json");

        if (!StringUtils.isEmpty(host)) {
            request.header("Host", host);
        }

        int code = request.code();
        String content = request.body();
        request.disconnect();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", code);
        result.put("content", content);
        return result;
    }

    public static Map<String, Object> request(String urlPath, String apiUrl, String action, String jsonPara, String token) {
        HttpRequest request = null;

//        //开发的时候需要设置的代理
//        HttpRequest.proxyHost("10.187.160.54");
//        HttpRequest.proxyPort(80);
//        //开发的时候需要设置的代理

        if (action.equalsIgnoreCase("get")) {
            request = HttpRequest.get(urlPath + apiUrl, true);
        } else if (action.equalsIgnoreCase("post")) {
            request = HttpRequest.post(urlPath + apiUrl, true);
        } else if (action.equalsIgnoreCase("delete")) {
            request = HttpRequest.delete(urlPath + apiUrl, true);
        } else if (action.equalsIgnoreCase("put")) {
            request = HttpRequest.put(urlPath + apiUrl, true);
        }
        request.header("Content-type", "application/json");

        if (!StringUtils.isEmpty(token)) {
            request.header("X-Auth-Token", token);
        }
        if (jsonPara != null && jsonPara.length() > 0) {
            request.send(jsonPara);
        }

        int code = request.code();
        String content = request.body();
        request.disconnect();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", code);
        result.put("content", content);
        return result;
    }

    public static Map<String, Object> request(String urlPath, String apiUrl, String action, String jsonPara) {
        HttpRequest request = null;
        if (action.equals("get")) {
            request = HttpRequest.get(urlPath + apiUrl, true);
        } else if (action.equals("post")) {
            request = HttpRequest.post(urlPath + apiUrl, true);
        } else if (action.equals("delete")) {
            request = HttpRequest.delete(urlPath + apiUrl, true);
        } else if (action.equals("put")) {
            request = HttpRequest.put(urlPath + apiUrl, true);
        }
        request.header("Content-type", "application/json");
        if (jsonPara != null && jsonPara.length() > 0) {
            request.send(jsonPara);
        }

        int code = request.code();
        String content = request.header("X-Subject-Token");
        request.disconnect();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", code);
        result.put("content", content);
        return result;
    }

    public static <T> T request(String url, String action, String json, Map<String,String> headers, Class<T> clazz){
        HttpRequest request = null;
        if (action.equals("get")) {
            request = HttpRequest.get(url, true);
        } else if (action.equals("post")) {
            request = HttpRequest.post(url, true);
        } else if (action.equals("delete")) {
            request = HttpRequest.delete(url, true);
        } else if (action.equals("put")) {
            request = HttpRequest.put(url, true);
        }
        request.header("Content-type", "application/json");

        if(!CollectionUtils.isEmpty(headers)){
            request.headers(headers) ;
        }

        if (json != null && json.length() > 0) {
            request.send(json);
        }

        try{
            int code = request.code();

            String content = request.body() ;

            if(logger.isInfoEnabled()){
                logger.info(String.format("url %s ,action %s ,json %s ,headers %s ,class %s ,result %s",
                        url,action,json, JSONUtils.toJSONString(headers),clazz.getName(),content));
            }

            T t  = JsonUtils.toJavaObject(content,clazz) ;

            return t ;

        }
        finally {
            if(request!= null){
                request.disconnect();
            }
        }
    }

    public static <T> T request(String url, String action, String json,Class<T> clazz){
        return request(url,action,json,null,clazz) ;
    }

    public static <T> T get(String url,Class<T> clazz) {
        return HttpUtils.request(url,"get","",clazz) ;
    }

    public static <T> T get(String url,Map<String,String> headers,Class<T> clazz) {
        return HttpUtils.request(url,"get","",headers,clazz) ;
    }

    public static <T> T post(String url,String json,Class<T> clazz) {
        return HttpUtils.request(url,"post",json,clazz) ;
    }

    public static <T> T post(String url,String json,Map<String,String> headers,Class<T> clazz) {
        return HttpUtils.request(url,"post",json,headers,clazz) ;
    }

    public static <T> T delete(String url,Class<T> clazz) {
        return HttpUtils.request(url,"delete","",clazz) ;
    }
}

