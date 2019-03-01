package com.tancy.thread.executor;

/**
 * @author tancy
 * @description description
 * @date 2019/3/1 11:39
 **/
public class WorkerThread implements Runnable {

    private String command;

    public WorkerThread(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println("thread name="+Thread.currentThread().getName()+" start time="+System.currentTimeMillis());
        proccessCommand();
        System.out.println("thread name="+Thread.currentThread().getName()+" end time="+System.currentTimeMillis());;
    }

    private void proccessCommand(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
