package com.tancy.desiginPattern.iterator.component;

import java.util.Iterator;

/**
 * @author tancy
 * @description description
 * @date 2019/3/30 18:19
 **/
public class NewWaitress {

    MenuComponent menuComponent;

    public NewWaitress(MenuComponent menuComponent) {
        this.menuComponent = menuComponent;
    }

    public void print(){
        menuComponent.print();
    }

    public void printVegetarMenu(){
        Iterator itr = menuComponent.createIterator();
        System.out.println("veger menu============");
        while (itr.hasNext()){
            MenuComponent mc = (MenuComponent) itr.next();
            try {
                if (mc.isVegetarian()){  //菜单判断抛出不支持的操作异常，保证统一的处理方式，保持透明性，即不用分别判断
                    mc.print();
                }
            } catch (UnsupportedOperationException e) {
                //抛出异常的方式，表明菜单不支持这个判断操作，如果用返回false替代，不符合语义，因为菜单没有这些属性
                e.printStackTrace();
            }
        }
    }

}
