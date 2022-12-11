package com.sustech.commonutils;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectUtils {
//    static MyHandler myHandler = new MyHandler();

    class MyHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("doing MyHandler invoke...");
            return null;
        }
    }

    public static Object createBean(String path) throws Exception {
        Class<?> cls = Class.forName(path);
        Object obj = cls.getConstructor().newInstance();
//        List<Field> fieldList = new ArrayList<>();
//        while (cls != null){
//            fieldList.addAll(new ArrayList<>(Arrays.asList(cls.getDeclaredFields())));
//            cls = cls.getSuperclass();
//        }
//        Field[] declaredFields = obj.getClass().getFields();
//        for (Field f : fieldList) {
//            f.setAccessible(true);
//            //3.判断属性值上面是否有自定义的autowired注解
//            Autowired annotation = f.getAnnotation(Autowired.class);
//            if (null != annotation) {
//                //4.获取属性对应的类
//                Class<?> type = f.getType();
//                //5.实例化对象
//                Object mapper = Proxy.newProxyInstance(
//                        ReflectUtils.class.getClassLoader(),//类加载器
//                        new Class[] { type },//接口数组
//                        myHandler
//                );
//                Object o = type.newInstance();
//                //6.通过反射给运行时对象的属性赋值
//                f.set(obj, o);
//            }
//        }
        return obj;
    }
}
