package com.michel.intrastructure.utils;


/**
 * 数据类型安全转换
 * Created by Michel on 2017/3/29.
 */

public class UConvert{

    private UConvert() {}

    public static int toInt(Object value, int defaultVal) {
        if (value == null || "".equals(value.toString().trim())) {
            return defaultVal;
        }
        try {
            return Integer.valueOf(value.toString());
        } catch (Exception e) {
            try {
                return Double.valueOf(value.toString()).intValue();
            } catch (Exception e1) {
                return defaultVal;
            }
        }
    }



    public static double toDouble(Object value, double defaultVal) {
        if (value == null || "".equals(value.toString().trim())) {
            return defaultVal;
        }
        try {
            return Double.valueOf(value.toString());
        } catch (Exception e) {
            return defaultVal;
        }
    }

    public static boolean toBoolean(Object value, boolean defaultVal) {
        if (value == null || value.toString().trim().isEmpty()) {
            return defaultVal;
        }
        return Boolean.valueOf(value.toString());
    }

    public static String toString(Object value, String defaultVal) {
        if (value == null || value.toString().trim().isEmpty()) {
            return defaultVal;
        } else {
            return value.toString();
        }
    }
}
