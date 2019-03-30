package com.tancy.desiginPattern.iterator;

/**
 * @author tancy
 * @description description
 * @date 2019/3/13 18:54
 **/
public class DinerMenu {
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("Vegetrain BLT", "Fakin bacon with lettuce &tomato on whole wheat", true, 2.99);
        addItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99);
        addItem("Soup of the day", "Soup of the day, with a side of potato salad", false, 3.29);
        addItem("Hotdog", "A hot dog, with saurkraut, relish, onions, topped with cheese", false, 3.05);
    }

    public void addItem(String name, String desc, boolean vegetarian, double price){
        MenuItem menuItem = new MenuItem(name,desc,vegetarian,price);
        if (numberOfItems >= MAX_ITEMS){
            System.out.println("sorry, menu is full!");
        }else {
            menuItems[numberOfItems++] = menuItem;
        }
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }


    public Itr createItr(){
        return new DinerMenuItr(menuItems);
    }


}
