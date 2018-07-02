package com.jd.dbw.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.codehaus.jackson.map.MappingJsonFactory;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;

/**
 * JSON转换工具
 *
 * @author zhangkaitao
 */
public class JSONHelper {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final ObjectMapper PRETTY_OBJECT_MAPPER = new ObjectMapper();
    private static final String JSON_CHARSET = "UTF-8";

    static {
        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        PRETTY_OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        PRETTY_OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private JSONHelper() {
    }


    public static String toJSON(Object obj) {
        return toJSON(obj, false);
    }

    public static String toJSON(Object obj, boolean pretty) {
        if (obj == null) {
            return null;
        }

        try {
            if (pretty) {
                return new String(OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsBytes(obj), JSON_CHARSET);
            } else {
                return new String(OBJECT_MAPPER.writeValueAsBytes(obj), JSON_CHARSET);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] toJSONAsBytes(Object obj) {
        if (obj == null) {
            return null;
        }

        try {
            return toJSON(obj).getBytes(JSON_CHARSET);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static <T> T fromJson(byte[] data, Class<T> javaType) throws Exception {
        if (data == null) {
            return null;
        }
        return fromJson(new String(data, JSON_CHARSET), javaType);
    }


    public static <T> T fromJson(String jsonAsString, Class<T> valueType) {
        if (org.apache.commons.lang.StringUtils.isBlank(jsonAsString)) {
            return null;
        }
        try {
            return (T) OBJECT_MAPPER.readValue(jsonAsString, valueType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJson(String jsonAsString, JavaType javaType) {
        if (org.apache.commons.lang.StringUtils.isBlank(jsonAsString)) {
            return null;
        }
        try {
            return (T) OBJECT_MAPPER.readValue(jsonAsString, javaType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 数组格式JSON串转换为ObjectList对象
     *
     * @param <T>
     * @param jsonString JSON字符串
     * @param tr         TypeReference,例如: new TypeReference< List<Album> >(){}
     * @return ObjectList对象
     */
    public static <T> T fromJson(String jsonString, TypeReference<T> tr) {

        if (jsonString == null || "".equals(jsonString)) {
            return null;
        } else {
            //Jackson方式将Json转换为对象
            MappingJsonFactory f = new MappingJsonFactory();
            f.configure(org.codehaus.jackson.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

            try {
                org.codehaus.jackson.JsonParser parser = f.createJsonParser(jsonString);
                return (T) parser.readValueAs(tr);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
