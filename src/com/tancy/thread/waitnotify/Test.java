package com.tancy.thread.waitnotify;

import com.tancy.thread.MyObject;

/**
 * @author tancy
 * @description description
 * @date 2019/2/27 10:30
 **/
public class Test {

    public static void main(String[] args) {
        MyObject obj=new MyObject();
        WaitThread wt=new WaitThread(obj);
        NotifyThread nt=new NotifyThread(obj);
        wt.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nt.start();
    }

}
