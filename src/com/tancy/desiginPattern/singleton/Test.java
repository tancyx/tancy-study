package com.tancy.desiginPattern.singleton;

public class Test {

    public static void main(String[] args) {
        LazySingleton lazySingleton1 =LazySingleton.getInstance();
        System.out.println(lazySingleton1);
        LazySingleton lazySingleton2 =LazySingleton.getInstance();
        System.out.println(lazySingleton2);

        InstanceThread thread=new InstanceThread();
        thread.start();
        LazySingletonSync lazySingletonSync1=LazySingletonSync.getInstance();
        System.out.println(lazySingletonSync1);



    }
}
