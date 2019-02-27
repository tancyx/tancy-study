package com.tancy.thread;

/**
 * @author tancy
 * @description description
 * @date 2019/2/26 13:28
 **/
public class MyObject {

    private int count=0;

    public int getCount() {
        return count;
    }

    public void add(){
        System.out.println("add count");
        count++;
    }

}
