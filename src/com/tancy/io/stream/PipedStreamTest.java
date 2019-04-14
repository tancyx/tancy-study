package com.tancy.io.stream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Arrays;

/**
 * @author tc
 * 2019/4/6 11:29
 * @description description
 */
public class PipedStreamTest {


    public class InputStreamThread implements Runnable{

        PipedInputStream pis;

        public InputStreamThread(PipedInputStream pis) {
            this.pis = pis;
        }

        @Override
        public void run() {
            byte[] buf = new byte[1024];
            int read;
            try {
                while ((read = pis.read(buf)) > 0){
                    System.out.println("thread name="+Thread.currentThread().getName()+" receive pipedoutstream");
                    System.out.println(Arrays.toString(buf));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (null != pis)
                    pis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class OutputStreamThread implements Runnable {

        PipedOutputStream pos;

        public OutputStreamThread(PipedOutputStream pos) {
            this.pos = pos;
        }

        @Override
        public void run() {
            byte[] bytes = new byte[]{23,11,1,4,5,6,7,99,10};
            try {
                System.out.println("thread name="+Thread.currentThread().getName()+" begin write");
                pos.write(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (null != pos)
                        pos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
