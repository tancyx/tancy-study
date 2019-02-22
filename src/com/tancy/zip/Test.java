package com.tancy.zip;

/**
 * @author tancy
 * @description description
 * @date 2019/2/21 15:10
 **/
public class Test {

    public static void main(String[] args) {
        ZipUtil zu=new ZipUtil("C:\\Users\\YX\\Desktop\\对账单测试数据\\201901","C:\\Users\\YX\\Desktop\\tmepzip\\");
        zu.doZip();
    }

}
