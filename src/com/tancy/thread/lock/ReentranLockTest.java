package com.tancy.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tancy
 * @description ReentrantLock 为排它锁，即同一时刻只允许一个线程访问
 * @date 2019/2/27 16:13
 **/
public class ReentranLockTest {

    public static void main(String[] args) {
        MyObject obj=new MyObject();
        ThreadA thread0=new ThreadA(obj);
//        ThreadA thread1=new ThreadA(obj);
//        ThreadA thread2=new ThreadA(obj);
//        ThreadA thread3=new ThreadA(obj);
//        ThreadA thread4=new ThreadA(obj);
//        ThreadA thread5=new ThreadA(new MyObject());

        thread0.start();
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();

        ThreadB threadB=new ThreadB(obj);
        threadB.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        obj.signal();
    }

    static class MyObject{

        private Lock lock=new ReentrantLock();
        private Condition condition=lock.newCondition();
        private Condition condition1=lock.newCondition();

        public void method0(){
            lock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
                }
            } finally {
                lock.unlock();
            }
        }

        public void await(){
            lock.lock();
            try {
                System.out.println("await method wait begin time="+ System.currentTimeMillis()+" thread name="+Thread.currentThread().getName());
                condition.await();
                System.out.println("await method signal begin time="+ System.currentTimeMillis()+" thread name="+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void signal(){
            lock.lock();
            try {
                System.out.println("signal begin time="+ System.currentTimeMillis()+" thread name="+Thread.currentThread().getName());
                condition.signal();
                Thread.sleep(1000);
                System.out.println("signal end time="+ System.currentTimeMillis()+" thread name="+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void await1(){
            lock.lock();
            try {
                System.out.println("await1 method wait begin time="+ System.currentTimeMillis()+" thread name="+Thread.currentThread().getName());
                condition1.await();
                System.out.println("await1 method signal begin time="+ System.currentTimeMillis()+" thread name="+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void signal1(){
            lock.lock();
            try {
                System.out.println("signal1 begin time="+ System.currentTimeMillis()+" thread name="+Thread.currentThread().getName());
                condition1.signal();
                Thread.sleep(1000);
                System.out.println("signal1 end time="+ System.currentTimeMillis()+" thread name="+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    static class ThreadA extends Thread {

        private MyObject obj;

        public ThreadA(MyObject obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            super.run();
//            obj.method0();
            obj.await();
        }
    }

    static class ThreadB extends Thread {

        private MyObject obj;

        public ThreadB(MyObject obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            super.run();
            obj.await1();
        }
    }

}
