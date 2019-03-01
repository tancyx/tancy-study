package com.tancy.thread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author tancy
 * @description ReentrantReadWriteLock 读写锁，对写操作互斥，读操作共享
 * @date 2019/2/28 13:20
 **/
public class ReentrantReadWriteLockTest {

    public static void main(String[] args) {
        ReadWriteTest rw=new ReadWriteTest();
        TreadA treadA=new TreadA(rw);
//        treadA.start();
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("结束延时");
//        System.out.println(rw.read());
//        rw.tryCatch();
    }


    static class ReadWriteTest {

        private ReentrantReadWriteLock rwl=new ReentrantReadWriteLock();

        public int read(){
            rwl.readLock().lock();
            System.out.println("获得读锁 线程名="+Thread.currentThread().getName()+" 时间="+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
                return 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
//                return 2;
            } finally {
                System.out.println("释放读锁 线程名="+Thread.currentThread().getName()+" 时间="+System.currentTimeMillis());
                rwl.readLock().unlock();
                return 3;
            }
//            return 4;
        }

        public void write(){
            rwl.writeLock().lock();
            System.out.println("获得写锁 线程名="+Thread.currentThread().getName()+" 时间="+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("释放写锁 线程名="+Thread.currentThread().getName()+" 时间="+System.currentTimeMillis());
                rwl.writeLock().unlock();
            }
        }

        public void tryCatch(){
            try {
                for (int i = 0; i < 10; i++) {
                    try {Class.forName("xx");
                        System.out.println(i);

                    } finally {
                        System.out.println("finally "+i);
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("exception"+e);
            } finally {
                System.out.println("finally outside");
            }
        }

    }

    static class TreadA extends Thread{

        ReadWriteTest rw;

        public TreadA(ReadWriteTest rw) {
            this.rw = rw;
        }

        @Override
        public void run() {
            super.run();
            rw.write();
        }
    }

    public class innTest{

    }

}
