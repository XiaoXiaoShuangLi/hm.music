package com.xxscloud.core;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 创建人: 李小双.
 * 创建时间:  2017/8/16.
 * 描述:
 */
public final class ToType {
    /**
     * 隐藏.
     */
    private ToType() {
    }

    /**
     * 转换为int 类型 .
     *
     * @param obj Object 对象
     * @return 处理结果
     */
    public static int toInt(final Object obj) {
        return ToType.toInt(obj, 0);
    }

    /**
     * 转换为int 类型.
     *
     * @param obj    Object 对象
     * @param result 如果失败的结果
     * @return 处理结果
     */
    public static int toInt(final Object obj, final int result) {
        try {
            String temp = String.valueOf(obj);
            int index = temp.indexOf(".");
            if (index > 0) {
                temp = temp.substring(0, index);
            }
            return Integer.parseInt(temp);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        return result;
    }


    /**
     * 转换为 long 类型.
     *
     * @param obj Object 对象
     * @return 处理结果
     */
    public static long toLong(final Object obj) {
        return toLong(obj, 0);
    }

    /**
     * 转换为 long 类型.
     *
     * @param obj    Object 对象
     * @param result 如果失败的结果
     * @return 处理结果
     */
    public static long toLong(final Object obj, final long result) {
        try {
            return Long.valueOf(String.valueOf(obj));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }


    /**
     * 转换为double 类型.
     *
     * @param obj Object 对象
     * @return 处理结果
     */
    public static double toDouble(final Object obj) {
        return toDouble(obj, 0);
    }

    /**
     * 转换为double 类型.
     *
     * @param obj    Object 对象
     * @param result 如果失败的结果
     * @return 处理结果
     */
    public static double toDouble(final Object obj, final double result) {
        try {
            return Double.valueOf(String.valueOf(obj));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * 转换为boolean 类型.
     *
     * @param obj Object 对象
     * @return 处理结果
     */
    public static boolean toBoolean(final Object obj) {
        return toBoolean(obj, false);
    }

    /**
     * 转换为boolean 类型.
     *
     * @param obj    Object 对象
     * @param result 如果失败的结果
     * @return 处理结果
     */
    public static boolean toBoolean(final Object obj, final boolean result) {
        try {
            return Boolean.valueOf(String.valueOf(obj));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }


    /**
     * 转成  Calendar.
     *
     * @param obj     Object 对象
     * @param pattern 时间格式
     * @param result  如果失败的结果
     * @return 处理结果
     */
    public static Calendar toCalendar(final Object obj, final String pattern, final Calendar result) {
        if (obj != null) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                Date date = simpleDateFormat.parse(String.valueOf(obj));
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                return calendar;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}
