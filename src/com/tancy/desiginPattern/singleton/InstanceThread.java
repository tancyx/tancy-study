package com.tancy.desiginPattern.singleton;

/**
 * @author tancy
 * @description description
 * @date 2019/2/26 15:59
 **/
public class InstanceThread extends Thread {

    @Override
    public void run() {
        super.run();
        LazySingletonSync obj= LazySingletonSync.getInstance();
        System.out.println(obj);
    }
}
