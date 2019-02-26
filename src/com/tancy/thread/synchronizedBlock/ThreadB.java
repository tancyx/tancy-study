package com.tancy.thread.synchronizedBlock;

import com.tancy.thread.MyObject;
import com.tancy.thread.PublicTest;

/**
 * @author tancy
 * @description description
 * @date 2019/2/26 13:38
 **/
public class ThreadB extends Thread {

    private PublicTest pt;
    private MyObject object;

    public ThreadB(PublicTest pt, MyObject object) {
        this.pt = pt;
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        pt.methodSynBlock0(object);
        PublicTest.print0();
        pt.print1();
    }
}
