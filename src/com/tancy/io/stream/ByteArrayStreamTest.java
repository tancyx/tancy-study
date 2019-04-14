package com.tancy.io.stream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author tc
 * 2019/4/6 10:49
 * @description description
 */
public class ByteArrayStreamTest {

    public void readArray(byte[] bytes){
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        byte[] buf = new byte[1024];
        int read;
        try {
            while ((read = bis.read(buf)) > 0){
                System.out.println(Arrays.toString(buf));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (null != bis)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void readArrayMarkAndReset(byte[] bytes, int mark){
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        bis.mark(mark);
        bis.skip(mark+1);
        byte[] buf = new byte[5];
        int read;
        try {
            while ((read = bis.read(buf)) > 0){
                System.out.println(Arrays.toString(buf));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        bis.reset();

        try {
            while ((read = bis.read(buf)) > 0){
                System.out.println(Arrays.toString(buf));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (null != bis)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
