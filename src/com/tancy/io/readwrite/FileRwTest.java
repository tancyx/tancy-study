package com.tancy.io.readwrite;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author tc
 * 2019/4/7 14:16
 * @description description
 */
public class FileRwTest {

    public void readFile(){
        FileReader fr = null;
        try {
            fr = new FileReader(new File("C:\\Users\\tc\\Desktop\\新建文本文档.txt"));
            char[] buf = new char[1024];
            int read;
            while ((read = fr.read(buf)) > 0){
                System.out.println(buf);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FileRwTest frw = new FileRwTest();
        frw.readFile();
    }

}
