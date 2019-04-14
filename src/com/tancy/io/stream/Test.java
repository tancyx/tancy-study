package com.tancy.io.stream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author tc
 * 2019/4/5 11:41
 * @description description
 */
public class Test {


    public static void main(String[] args) {
        FileStreamTest ft = new FileStreamTest();
        ft.readFile();

        ByteArrayStreamTest bt = new ByteArrayStreamTest();
//        bt.readArray(new byte[]{21,2,1,33,4,6,5,10,19});
        bt.readArrayMarkAndReset(new byte[]{21,2,1,33,4,6,5,10,19},1);

        System.out.println("=============================");

        PipedStreamTest pst = new PipedStreamTest();
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = null;
        try {
            pos =new PipedOutputStream(pis);
            PipedStreamTest.InputStreamThread thread1 = pst.new InputStreamThread(pis);
            PipedStreamTest.OutputStreamThread thread2 = pst.new OutputStreamThread(pos);

            Thread t2 = new Thread(thread2);
            t2.run();
            Thread t1 = new Thread(thread1);
            t1.run();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("main end");

    }

}
