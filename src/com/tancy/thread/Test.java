package com.tancy.thread;

/**
 * @author tancy
 * @description description
 * @date 2019/2/21 11:38
 **/
public class Test {

    public static void main(String[] args) {
        PublicTest pt=new PublicTest();
        ThreadA threadA=new ThreadA(pt);
        threadA.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pt.getValue();
    }

}
