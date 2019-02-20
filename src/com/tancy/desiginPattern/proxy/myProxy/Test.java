package com.tancy.desiginPattern.proxy.myProxy;

import com.tancy.desiginPattern.proxy.RedWineProduct;
import com.tancy.desiginPattern.proxy.WineProduct;

/**
 * @author tancy
 * @description description
 * @date 2019/2/19 18:09
 **/
public class Test {

    public static void main(String[] args) {
        WineProduct wp=new RedWineProduct();
        MyInvokeHandler myInvokeHandler=new ImplInvokeHandler(wp);
        long start= System.currentTimeMillis();
        WineProduct wpproxy= (WineProduct) MyProxy.createProxyInstance(wp.getClass().getInterfaces(),myInvokeHandler);
        wpproxy.sell();
        System.out.println(System.currentTimeMillis()-start);
    }

}
