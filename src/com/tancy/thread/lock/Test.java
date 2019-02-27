package com.tancy.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tancy
 * @description description
 * @date 2019/2/27 15:53
 **/
public class Test {

    public static void main(String[] args) {
        ReentrantLock lock=new ReentrantLock();
        try {
            lock.lock();
            Class.forName("xx");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println(lock.isHeldByCurrentThread());
        }

    }

}
