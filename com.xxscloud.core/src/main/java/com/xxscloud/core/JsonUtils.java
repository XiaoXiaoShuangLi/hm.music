package com.xxscloud.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

/**
 * @author 李小双 2018.1.1
 */
public final class JsonUtils {

    /**
     * GSONParser 对象.
     */
    private static final Gson GSON_PARSER;

    static {
        GSON_PARSER = new GsonBuilder().create();
    }


    /**
     * 禁止初始化.
     */
    private JsonUtils() {

    }

    /**
     * 将一个Object 对象 转换成一个JSON 字符串.
     *
     * @param <T> 模型
     * @param obj 任意对象
     * @return JSON 字符串
     */
    public static <T> String toJson(final T obj) {
        if (obj != null) {
            return GSON_PARSER.toJson(obj);
        }
        return "{}";
    }

    /**
     * 将一个JSON 字符串转换成一个Object 对象.
     *
     * @param <T>  模型
     * @param json JSON 字符串
     * @param type 任意对象类型
     * @return T 对象
     */
    public static <T> T toObject(final String json, final Class<T> type) {
        return GSON_PARSER.fromJson(json, type);
    }

    /**
     * 将一个JSON 字符串转换成一个Object List 对象.
     *
     * @param <T>  模型
     * @param json JSON 字符串
     * @param type 任意对象类型
     * @return List<T> 数据
     */
    public static <T> List<T> toObjectList(final String json, final Type type) {
        return GSON_PARSER.fromJson(json, type);
    }

    /**
     * 将一个JSON 字符串转换成一个Object List 对象忽略大小写.
     *
     * @param <T>   模型
     * @param json  JSON 字符串
     * @param type  任意对象类型_
     * @param state 获得状态
     * @return List<T> 数据
     */
    public static <T> List<T> toObjectList(final String json, final Type type, final boolean state) {
        List<Map<String, Object>> objectList = GSON_PARSER.fromJson(json, new TypeToken<List<Map>>() {
        }.getType());

        objectList = escapes(objectList);

        return GSON_PARSER.fromJson(toJson(objectList), type);
    }

    /**
     * 将参数转义.
     *
     * @param objectList Object List
     * @return 转以后的数据
     */
    private static List<Map<String, Object>> escapes(final List<Map<String, Object>> objectList) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (Map<String, Object> dataMap : objectList) {
            Map<String, Object> temp = new HashMap<>();
            for (Map.Entry<String, Object> mapValue : dataMap.entrySet()) {
                Object value = mapValue.getValue();
                if (value instanceof ArrayList) {
                    value = escapes((List<Map<String, Object>>) value);
                }
                temp.put(mapValue.getKey().substring(0, 1).toLowerCase() + mapValue.getKey().substring(1), value);
            }
            resultList.add(temp);
        }
        return resultList;
    }

    /**
     * 将一个JSON 字符串转成一个JSONObject 对象.
     *
     * @param json JSON 字符串
     * @return JSONObject 对象
     */
    public static LinkedTreeMap toObject(final String json) {
        return (LinkedTreeMap) GSON_PARSER.fromJson(json, Object.class);
    }


    public static <T> Object toBean(Object data, Class<T> targetClass) {
        Object result;
        if (Objects.isNull(data)) {
            return null;
        } else if (Integer.class.equals(targetClass)) {
            result = Integer.parseInt(data.toString());
        } else if (Long.class.equals(targetClass)) {
            result = Long.parseLong(data.toString());
        } else if (Date.class.equals(targetClass)) {
            final String value = "[0-9]+";
            if (data.toString().matches(value)) {
                result = new Date(Long.parseLong(data.toString()));
            } else {
                throw new IllegalArgumentException("日期必须是长整型的时间戳");
            }
        } else if (String.class.equals(targetClass)) {
            if (data instanceof String) {
                result = data;
            } else {
                throw new IllegalArgumentException("转换目标类型为字符串");
            }
        } else {
            result = toObject(toJson(data), targetClass);
        }
        return result;
    }

}
