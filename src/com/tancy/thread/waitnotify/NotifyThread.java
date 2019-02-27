package com.tancy.thread.waitnotify;

import com.tancy.thread.MyObject;

/**
 * @author tancy
 * @description description
 * @date 2019/2/27 10:23
 **/
public class NotifyThread extends Thread {
    MyObject obj;

    public NotifyThread(MyObject obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj){
            while (obj.getCount()<11){
                obj.add();
                if (obj.getCount()==5){
                    obj.notify();
                    System.out.println("notify time "+System.currentTimeMillis());
                }
                System.out.println("count="+obj.getCount());
            }
        }
    }
}
