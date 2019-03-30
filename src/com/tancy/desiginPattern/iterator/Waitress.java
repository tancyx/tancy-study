package com.tancy.desiginPattern.iterator;

import java.util.ArrayList;

/**
 * @author tancy
 * @description description
 * @date 2019/3/13 19:11
 **/
public class Waitress {

    PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
    DinerMenu dinerMenu = new DinerMenu();

    public void printMenu(){
//        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
//        ArrayList<MenuItem> list1 = pancakeHouseMenu.getMenuItems();

//        DinerMenu dinerMenu = new DinerMenu();
//        MenuItem[] array1 = dinerMenu.getMenuItems();

//        for (MenuItem menuItem : list1) {
//            System.out.println(menuItem.getName()+","+menuItem.getDesc()+","+menuItem.getPrice());
//        }
//
//        System.out.println("==========================");
//
//        for (int i = 0; i < dinerMenu.numberOfItems; i++) {
//            MenuItem menuItem = array1[i];
//            System.out.println(menuItem.getName()+","+menuItem.getDesc()+","+menuItem.getPrice());
//        }
        Itr itr1 = pancakeHouseMenu.createItr();
        Itr itr2 = dinerMenu.createItr();
        printMenu(itr1);
        System.out.println("================");
        printMenu(itr2);

    }

    public void printMenu(Itr itr){
        while (itr.hasNext()){
            MenuItem menuItem = (MenuItem) itr.next();
            System.out.println(menuItem.getName()+","+menuItem.getDesc()+","+menuItem.getPrice());
        }
    }

}
