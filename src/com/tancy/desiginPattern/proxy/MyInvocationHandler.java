package com.tancy.desiginPattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private WineProduct wp;

    public MyInvocationHandler(RedWineProduct wp) {
        this.wp = wp;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy begin");
        method.invoke(wp,args);
        System.out.println("proxy end");
        return wp;
    }
}
