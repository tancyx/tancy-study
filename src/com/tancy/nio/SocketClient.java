package com.tancy.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketClient {

    public static String STR="tancy test!";

    public static final int PORT=1234;
    public static final String IP="127.0.0.1";
    public static final int THREAD_NUMBER=2;

    private static class NioBlockingThread extends Thread{

        @Override
        public void run() {
            try {
                SocketChannel sc=SocketChannel.open(new InetSocketAddress(IP,PORT));
                sc.configureBlocking(false);
                while (!sc.finishConnect()){
                    System.out.println("正在建立与"+IP+"的连接，请稍等...");
                    Thread.sleep(10);
                }
                System.out.println("连接已建立，等待写入内容至指定ip");
                String trans=STR+this.getName();
                ByteBuffer bb=ByteBuffer.allocate(trans.length());
                bb.put(trans.getBytes());
                bb.flip();
                sc.write(bb);
                bb.clear();
                sc.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        NioBlockingThread[] nios=new NioBlockingThread[THREAD_NUMBER];
        for (int i=0;i<THREAD_NUMBER;i++)
            nios[i]=new NioBlockingThread();
        for (int i=0;i<THREAD_NUMBER;i++)
            nios[i].start();
        for (int i=0;i<THREAD_NUMBER;i++)
            try {
                nios[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }


}
