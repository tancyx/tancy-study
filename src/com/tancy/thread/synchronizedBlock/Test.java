package com.tancy.thread.synchronizedBlock;

import com.tancy.thread.MyObject;
import com.tancy.thread.PublicTest;

/**
 * @author tancy
 * @description description
 * @date 2019/2/26 13:43
 **/
public class Test {

    public static void main(String[] args) {
        PublicTest pt=new PublicTest();
        MyObject object0=new MyObject();
        MyObject object1=new MyObject();
        ThreadB threadB0=new ThreadB(pt,object0);
        ThreadB threadB1=new ThreadB(pt,object0);
        ThreadB threadB2=new ThreadB(pt,object1);
        threadB0.start();
        threadB1.start();
        threadB2.start();
    }

}
