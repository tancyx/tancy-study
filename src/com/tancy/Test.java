package com.tancy;

import com.tancy.desiginPattern.proxy.WineProduct;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            Class[] params=method.getParameterTypes();
            for (Class clazz : params) {
                System.out.println("getParameterTypes:"+clazz.getSimpleName());
            }
            Type[] types=method.getGenericParameterTypes();
            for (Type type : types) {
                System.out.println("getGenericParameterTypes:"+type.getTypeName());
            }

        }
        Constructor[] constructors=Test.class.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        List list=new ArrayList();
        System.out.println(list.getClass().getSimpleName());
        Test[] ta=new Test[]{new Test(),new Test(),new Test()};
        System.out.println(Arrays.deepToString(ta));

        Path path= Paths.get("./src");
        try {
            System.out.println(path.toRealPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Files.exists(path));

    }


    public static int hashx(java.lang.Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}
