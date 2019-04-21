package com.tancy.desiginPattern.iterator.component;

/**
 * @author tc
 * 2019/4/21 12:10
 * @description description
 */
public class Test {


    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu = new Menu("pancake house menu", "breakfast");
        MenuComponent dinerMenu = new Menu("diner menu", "lunch");
        MenuComponent cafeMenu = new Menu("cafemenu", "dinner");
        MenuComponent dessertMenu = new Menu("dessertmenu", "dessert of course");

        MenuComponent allMenus = new Menu("all menus", "all menu combined");
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        dinerMenu.add(new MenuItem("pasta", "spaghetti with marinara sauce, and a slice of sourdough bread",1.59, true));
        dinerMenu.add(dessertMenu);

        dessertMenu.add(new MenuItem("apple pie","apple pie with a flakey crust, topped with vanilla ice cream",3.33,true));

        cafeMenu.add(new MenuItem("cafe","nodesc",2.34,false));

        NewWaitress waitress = new NewWaitress(allMenus);

        waitress.printVegetarMenu();
    }

}
