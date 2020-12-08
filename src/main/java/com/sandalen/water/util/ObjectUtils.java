package com.sandalen.water.util;

public class ObjectUtils {
    public static boolean isEmpty(Object obj){
        return obj == null || obj == "";
    }

    public static boolean isStringEmpty(String str){
        return str.equals(" ") || str.length() == 0 || str == null;
    }
}
