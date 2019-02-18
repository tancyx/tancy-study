package com.tancy.desiginPattern.proxy.myProxy;

import com.tancy.desiginPattern.proxy.WineProduct;

import java.lang.reflect.Method;

/**
 * @author tancy
 * @description description
 * @date 2019/2/18 18:12
 **/
public class ImplInvokeHandler implements MyInvokeHandler {
    WineProduct wp;

    public ImplInvokeHandler(WineProduct wp) {
        this.wp = wp;
    }

    @Override
    public void inovke(Method method) {

    }
}
