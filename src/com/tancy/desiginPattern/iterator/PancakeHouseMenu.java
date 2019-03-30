package com.tancy.desiginPattern.iterator;

import java.util.ArrayList;

/**
 * @author tancy
 * @description description
 * @date 2019/3/13 18:49
 **/
public class PancakeHouseMenu{
    ArrayList menuItems;

    public PancakeHouseMenu() {
        this.menuItems = new ArrayList();
        addItem("K&B's pancake breakfast","pancake with scrambled eggs, and toast",true,2.99);
        addItem("Regular pancake breakfast","pancake with fired eggs, and sausage",false,2.99);
        addItem("Blueberry pancake breakfast","pancake with fresh blueberry",true,3.49);
        addItem("Waffles","waffles, with your choice of blueberry or strawberries",true,3.59);
    }

    public void addItem(String name, String desc, boolean vegetarian, double price){
        MenuItem menuItem = new MenuItem(name,desc,vegetarian,price);
        menuItems.add(menuItem);
    }

    public ArrayList getMenuItems() {
        return menuItems;
    }

    public Itr createItr(){
        return new PancakeHouseMenuItr(menuItems);
    }

}
