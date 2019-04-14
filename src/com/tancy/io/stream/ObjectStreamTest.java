package com.tancy.io.stream;

import java.io.*;
import java.math.BigDecimal;

/**
 * @author tc
 * 2019/4/6 16:47
 * @description description
 */
public class ObjectStreamTest {

    public void readObject(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("C:\\Users\\tc\\Desktop\\obj.data"));
            SerializableObj sobj = (SerializableObj) ois.readObject();
            System.out.println(sobj.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if (null != ois){
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public void writeObject(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\tc\\Desktop\\obj.data"));
            oos.writeObject(new SerializableObj("tancy", 25, 100, new BigDecimal(99999999)));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (null != oos){
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ObjectStreamTest ost = new ObjectStreamTest();
        ost.writeObject();

        ost.readObject();

        System.out.println("完成！");
    }

}
