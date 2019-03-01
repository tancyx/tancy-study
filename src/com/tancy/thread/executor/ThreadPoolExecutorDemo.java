package com.tancy.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author tancy
 * @description description
 * @date 2019/3/1 13:27
 **/
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {
        ExecutorService executor= Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            Runnable work=new WorkerThread("command"+i);
            executor.execute(work);
        }

        executor.shutdown();
        while (true){

            if (executor.isTerminated()){
                System.out.println("finish all thread");
            }
            if (executor.isShutdown()){
                System.out.println("finish executor");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
