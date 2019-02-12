package com.tancy.desiginPattern.decorator.jdkDecorator;

import java.io.*;

public class Test {

    public static void main(String[] args) {
        int r;
        try {
            InputStream in=new CustomInputDecorator(new BufferedInputStream(new FileInputStream("C:\\Users\\tc\\Desktop\\test.txt")));
            while ((r= in.read())>=0){
                System.out.print((char)r);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){

        }
    }
}
