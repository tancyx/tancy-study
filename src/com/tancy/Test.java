package com.tancy;

import com.tancy.desiginPattern.proxy.WineProduct;

import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) {
//        int length=3;
//        System.out.println(hash("xx"));
//        System.out.println(hash("xx"));
        System.out.println(Test.class.getName());
        System.out.println(Test.class.getCanonicalName());
        System.out.println(Test.class.getSimpleName());
        System.out.println("");
        Method[] methods=Test.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            System.out.println(method.getReturnType().getSimpleName());
        }
        System.out.println();
    }


    public static int hashx(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}
