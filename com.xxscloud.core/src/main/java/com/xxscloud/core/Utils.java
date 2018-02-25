package com.xxscloud.core;


import com.sun.istack.internal.NotNull;

import java.util.Objects;
import java.util.Random;


/**
 * @author 李小双 2018.1.1
 */
public final class Utils {

    /**
     * 缓存一个时间
     */
    private static long timeCache;

    /**
     * 后缀.
     */
    private static int timeIndex;

    private final static Random RANDOM;


    static {
        RANDOM = new Random();
    }


    /**
     * 隐藏.
     */
    private Utils() {
    }

    /**
     * 判断是否是NULL或者空字符串.
     *
     * @param value 字符串
     * @return true 空 false 不为空
     */
    public static boolean isNullOrEmpty(final String value) {
        return Objects.isNull(value) || Objects.equals(value.trim(), "");
    }


    /**
     * 强制转化 .
     *
     * @param obj  Object 对象
     * @param type 转换类型
     * @param <T>  强制转换的类型Class
     * @return 不成功则为NULL
     */
    public static <T> T asType(final Object obj, final Class<T> type) {
        if (type.isInstance(obj)) {
            return (T) obj;
        } else {
            return null;
        }
    }


    /**
     * 唯一Id .
     *
     * @return 唯一Id .
     */
    public static synchronized String createId() {
        long time = System.currentTimeMillis();
        if (timeCache == time) {
            timeIndex += 1;
        } else {
            timeIndex = 1;
        }
        timeCache = time;
        StringBuilder result = new StringBuilder();
        result.append(timeIndex);
        for (int i = result.length(); i <= 3; i++) {
            result.insert(0, "0");
        }
        return String.valueOf(time) + result;
    }

    /**
     * 解析字符串.
     * 处理可能参数空的数据
     *
     * @param data 数据源
     * @param c    分割符
     * @return 解析后的结果
     */
    @NotNull
    public static String parseSplitString(String data, char c) {
        if (Objects.isNull(data)) {
            return "";
        }
        int index = data.lastIndexOf(c);
        if (Objects.equals(index, data.length() - 1)) {
            return data.substring(0, index);
        }
        return data;
    }

    /**
     * 获得一个指定范围的随机数
     *
     * @param minValue 最小值
     * @param maxValue 最大值
     * @return 随机值
     */
    public static int getRandom(final int minValue, final int maxValue) {
        return RANDOM.nextInt(maxValue) % (maxValue - minValue + 1) + minValue;
    }
}
