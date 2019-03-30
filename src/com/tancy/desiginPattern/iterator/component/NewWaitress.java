package com.tancy.desiginPattern.iterator.component;

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

}
