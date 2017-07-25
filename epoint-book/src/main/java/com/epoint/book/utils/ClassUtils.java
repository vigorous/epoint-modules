package com.epoint.book.utils;

import java.lang.reflect.Method;

/**
 * Created by chiang on 2017/3/3.
 */
public class ClassUtils {
    private ClassUtils(){}

    public static <R,T> R invokeGetMethod(T obj,String fieldName) throws Exception{
        Class clz = obj.getClass();
        String firstChar = fieldName.substring(0,1).toUpperCase();
        String methodName = "get" + firstChar + fieldName.substring(1);

        Method m = clz.getMethod(methodName);
        m.setAccessible(true);
        Object result = m.invoke(obj);
        return (R)result;
    }

    public static <T,V> void invokeSetMethod(T obj,String fieldName,V value) throws Exception{
        Class clz = obj.getClass();
        String firstChar = fieldName.substring(0,1).toUpperCase();
        String methodName = "set" + firstChar + fieldName.substring(1);
        Method m = clz.getMethod(methodName,value.getClass());
        m.setAccessible(true);
        m.invoke(obj,value);
    }

}
