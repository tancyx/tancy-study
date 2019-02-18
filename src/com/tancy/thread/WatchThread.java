package com.tancy.thread;

/**
 * @author tancy
 * @description 测试守护线程
 * @date 2019/2/15 17:55
 **/
public class WatchThread extends Thread {

    private int i=0;

    @Override
    public void run() {
//        try {
            while (true){
                System.out.println("i="+i);
                i++;
//                Thread.sleep(100);
            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) {
        try {
            WatchThread watchThread=new WatchThread();
            watchThread.setDaemon(true);
            watchThread.start();
            Thread.sleep(100);
            System.out.println("我离开thread对象也不再打印了，也就是停止了！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
