package com.tancy.desiginPattern.singleton;

public class Test {

    public static void main(String[] args) {
        LazySingleton lazySingleton1 =LazySingleton.getInstance();
        System.out.println(lazySingleton1);
        LazySingleton lazySingleton2 =LazySingleton.getInstance();
        System.out.println(lazySingleton2);
    }
}
