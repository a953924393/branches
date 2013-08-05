package com.jingpaidang.tools.common.utils;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletResponse;

/**
 * Util class for processing JSON objects and strings.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 5/24/13
 */
public class JSONUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        objectMapper.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    /**
     * 将对象转换为JSON字符串
     *
     * @param object object
     */
    public static String toJson(Object object) {
        Assert.notNull(object);
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将对象转换为json流
     *
     * @param response HttpServletResponse
     * @param contentType type of content
     * @param value       Object
     */
    public static void toJson(HttpServletResponse response, String contentType, Object value) {
        Assert.notNull(response);
        Assert.notNull(contentType);
        Assert.notNull(value);
        try {
            response.setContentType(contentType);
            objectMapper.writeValue(response.getWriter(), value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将对象转换为JSON流
     *
     * @param response HttpServletResponse
     * @param value    Object
     */
    public static void toJson(HttpServletResponse response, Object value) {
        Assert.notNull(response);
        Assert.notNull(value);
        try {
            objectMapper.writeValue(response.getWriter(), value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将JSON字符串转换为对象
     *
     * @param json      JSON characters
     * @param valueType object type
     */
    public static <T> T toObject(String json, Class<T> valueType) {
        Assert.notNull(json);
        Assert.notNull(valueType);
        try {
            return objectMapper.readValue(json, valueType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将JSON字符串转换为对象
     *
     * @param json          JSON characters
     * @param typeReference Object type
     */
    public static <T> T toObject(String json, TypeReference<?> typeReference) {
        Assert.notNull(json);
        Assert.notNull(typeReference);
        try {
            return (T) objectMapper.readValue(json, typeReference);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将JSON字符串转换为对象
     *
     * @param json     JSON characters
     * @param javaType Object type
     */
    public static <T> T toObject(String json, JavaType javaType) {
        Assert.notNull(json);
        Assert.notNull(javaType);
        try {
            return (T) objectMapper.readValue(json, javaType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}
