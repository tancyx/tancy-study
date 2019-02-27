package com.tancy.thread.waitnotify;

import com.tancy.thread.MyObject;

/**
 * @author tancy
 * @description description
 * @date 2019/2/27 10:03
 **/
public class WaitThread extends Thread {
    private MyObject obj;

    public WaitThread(MyObject obj) {
        this.obj = obj;
    }


    @Override
    public void run() {
        synchronized (obj) {
            if (obj.getCount() != 5) {
                System.out.println("wait begin " + System.currentTimeMillis());
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait end "+ System.currentTimeMillis());
            }
        }
    }
}
