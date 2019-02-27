package com.tancy.thread.threalocal;

/**
 * @author tancy
 * @description description
 * @date 2019/2/27 11:14
 **/
public class Test  {

    private static final String DEFAULTLOCAL="default";

    public static ThreadLocal<String> local=new ThreadLocal<>();

    public static void main(String[] args) {
        System.out.println(new Test.LocalThreadTest().get());
    }

    public static class LocalThreadTest extends ThreadLocal{
        @Override
        protected Object initialValue() {
            return DEFAULTLOCAL;
        }
    }

}
