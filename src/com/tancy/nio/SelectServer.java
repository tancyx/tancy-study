package com.tancy.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectServer {

    public static final int PORT = 1234;
    public static ByteBuffer bb=ByteBuffer.allocate(1024);

    public static void main(String[] args) {
        try {
            //打开服务通道
            ServerSocketChannel ssc=ServerSocketChannel.open();
            //由服务通道获取一个server socket
            ServerSocket sc= ssc.socket();
            //设置监听端口
            sc.bind(new InetSocketAddress(PORT));
            //设置服务通道为非阻塞
            ssc.configureBlocking(false);
            //打开一个选择器
            Selector selector=Selector.open();
            ssc.register(selector,SelectionKey.OP_ACCEPT);

            while (true){
                int n=selector.select();
                if (n<=0) {
                    continue;
                }
                //获取已选择键集
                Set<SelectionKey> selectionKeys=selector.selectedKeys();
                Iterator iterator=selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey sk= (SelectionKey) iterator.next();

                    if (sk.isAcceptable()){
                        ServerSocketChannel sscl= (ServerSocketChannel) sk.channel();
                        SocketChannel scl= sscl.accept();
                        scl.configureBlocking(false);
                        scl.register(selector,SelectionKey.OP_READ);
                    }else if (sk.isReadable()){
                        readSocketChannel(sk);
                    }
                    iterator.remove();

                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static void readSocketChannel(SelectionKey selectionKey) throws IOException {
        SocketChannel sc= (SocketChannel) selectionKey.channel();
        bb.clear();
        while (sc.read(bb)>0){
            bb.flip();
            while (bb.hasRemaining()){
                System.out.print((char)bb.get());
            }
            bb.clear();
        }
    }

}
