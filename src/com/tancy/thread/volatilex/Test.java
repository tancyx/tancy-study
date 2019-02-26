package com.tancy.thread.volatilex;

/**
 * @author tancy
 * @description description
 * @date 2019/2/26 15:35
 **/
public class Test {
    public static void main(String[] args) {
        RunTread runTread=new RunTread();
        Thread thread=new Thread(runTread);
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        runTread.setRuning(false);
        System.out.println("runing 改为 false");
    }
}
