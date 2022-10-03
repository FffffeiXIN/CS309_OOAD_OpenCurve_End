package com.sustech.commonutils;

public class ReflectUtils {


    public static Object createBean(String path) throws Exception{
        Class<?> cls= Class.forName(path);
        return cls.getConstructor().newInstance();
    }


}
