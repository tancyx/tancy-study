package com.tancy.thread;

/**
 * @author tancy
 * @description description
 * @date 2019/2/21 11:25
 **/
public class PublicTest {

    private String var1="A";

    private String var2="AA";

    synchronized public void setValue(String var1,String var2){
        this.var1=var1;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.var2=var2;
        System.out.println("setValue method thread name="+Thread.currentThread().getName()+" var1="+this.var1+" var2="+this.var2);
    }

    public void getValue(){
        System.out.println("getValue method thread name="+Thread.currentThread().getName()+" var1="+this.var1+" var2="+this.var2);
    }


    public void methodSynBlock0(MyObject object){
        synchronized (object){
            System.out.println("methodSynBlock0 getlocktime="+System.currentTimeMillis()+" thread name="+Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("methodSynBlock0 releaselocktime="+System.currentTimeMillis()+" thread name="+Thread.currentThread().getName());
        }
    }

    synchronized public static void print0(){
        System.out.println("print0 getlocktime="+System.currentTimeMillis()+" thread name="+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("print0 releaselocktime="+System.currentTimeMillis()+" thread name="+Thread.currentThread().getName());
    }

    public void print1(){
        synchronized (PublicTest.class) {
            System.out.println("print1 getlocktime=" + System.currentTimeMillis() + " thread name=" + Thread.currentThread().getName());
            System.out.println("print1 releaselocktime=" + System.currentTimeMillis() + " thread name=" + Thread.currentThread().getName());
        }
    }


}
