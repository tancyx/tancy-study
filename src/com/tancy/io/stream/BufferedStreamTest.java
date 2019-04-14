package com.tancy.io.stream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author tc
 * 2019/4/6 15:17
 * @description description
 */
public class BufferedStreamTest {

    public void readBuffer(){
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\tc\\Desktop\\新建文本文档.txt"));
            bis.mark(0);
            int read;
            byte[] buf = new byte[1024];
            while ((read = bis.read(buf)) > 0){
                System.out.println(Arrays.toString(buf));
                System.out.println(new String(buf, "GB2312"));
            }

            System.out.println("=========================");

            buf = new byte[1024];
            bis.reset();
            bis.skip(0);
            while ((read = bis.read(buf)) > 0){
                System.out.println(Arrays.toString(buf));
                System.out.println(new String(buf, "GB2312"));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BufferedStreamTest bt = new BufferedStreamTest();
        bt.readBuffer();
    }

}
