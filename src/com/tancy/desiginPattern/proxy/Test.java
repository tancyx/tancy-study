package com.tancy.desiginPattern.proxy;

import java.lang.reflect.Proxy;

public class Test {


    public static void main(String[] args) {
        RedWineProduct rwp=new RedWineProduct();
        MyInvocationHandler mi=new MyInvocationHandler(rwp);
        long start=System.currentTimeMillis();
        WineProduct wp= (WineProduct) Proxy.newProxyInstance(rwp.getClass().getClassLoader(),rwp.getClass().getInterfaces(),mi);
        wp.sell();
        System.out.println(System.currentTimeMillis()-start);

    }

}
