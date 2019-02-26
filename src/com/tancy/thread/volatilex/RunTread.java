package com.tancy.thread.volatilex;

/**
 * @author tancy
 * @description description
 * @date 2019/2/26 15:28
 **/
public class RunTread implements Runnable {

    private volatile boolean isRuning=true;
    int m;

    public boolean isRuning() {
        return isRuning;
    }

    public void setRuning(boolean runing) {
        isRuning = runing;
    }

    @Override
    public void run() {
        System.out.println("线程 start");
        while (isRuning==true){
            int a=1,b=2,c=a+b;
            this.m=c;
//            System.out.println(m);  这2处作用是在没有volatile关键字修饰变量时，也能获取变量更新的值
//            Thread.sleep(10);       因为jvm会在CPU空闲时会尽力保证内存的可见性
        }
        System.out.println(m);
        System.out.println("线程 end");
    }
}
