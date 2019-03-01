package com.tancy.thread.executor;

import java.sql.Time;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author tancy
 * @description description
 * @date 2019/3/1 16:27
 **/
public class ScheduledThreadPoolExecutorTest {

    public static void main(String[] args) {
        ScheduledExecutorService schedule= Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 3; i++) {
            Runnable worker=new WorkerThread("schedule work");
            schedule.schedule(worker,10, TimeUnit.NANOSECONDS);
        }

        System.out.println("finish ");

    }

}
