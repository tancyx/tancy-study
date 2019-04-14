package com.tancy.io.stream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author tc
 * 2019/4/7 13:29
 * @description description
 */
public class DataStreamTest {

    public void readData(){
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("C:\\Users\\tc\\Desktop\\新建文本文档.txt"));
            char c;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != dis){
                    dis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
