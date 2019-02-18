package com.tancy.desiginPattern.proxy.myProxy;

import java.lang.reflect.Method;

/**
 * @author tancy
 * @description 自己实现简单的动态代理调用处理器接口
 * @date 2019/2/18 9:51
 **/
public interface MyInvokeHandler {

    void inovke(Method method);

}
