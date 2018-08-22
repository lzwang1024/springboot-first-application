package com.lzwang.learn.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by lzwang on 2018/8/21.
 */
public class Test1 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        Class c1 = int.class;
//        Class c2 = int.class;
//        System.out.println(c1 == c2);
//
//        ClassLoader classLoader =  ClassLoader.getSystemClassLoader();
//        classLoader.loadClass("Test1");


        Class clazz = Class.forName("ManagerBean");
        Object obj = clazz.newInstance();

        Method setName = clazz.getMethod("setName", String.class);
        if(!setName.isAccessible()) {
            setName.setAccessible(true);
        }
        Object returnValue = setName.invoke(obj, "lzwang");

        System.out.println(returnValue);

    }

}
