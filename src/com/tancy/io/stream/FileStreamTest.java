package com.tancy.io.stream;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @author tc
 * 2019/4/6 9:49
 * @description description
 */
public class FileStreamTest {

    public void readFile(){
        FileInputStream fis = null;
        System.out.println(Charset.defaultCharset());
        try {
            fis = new FileInputStream("C:\\Users\\tc\\Desktop\\新建文本文档.txt");
            byte[] buf = new byte[10];
            int read = 0;
            while ((read = fis.read(buf)) > 0){
                System.out.println(Arrays.toString(buf));
                System.out.println(new String(buf,0,read,"GB2312"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (null != fis)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
