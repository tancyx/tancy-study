package com.tancy.thread;

/**
 * @author tancy
 * @description description
 * @date 2019/2/21 11:35
 **/
public class ThreadA extends Thread {

    PublicTest pt;

    public ThreadA(PublicTest pt) {
        this.pt = pt;
    }

    @Override
    public void run() {
        pt.setValue("B","BB");
    }
}
