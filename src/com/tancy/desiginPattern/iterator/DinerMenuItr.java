package com.tancy.desiginPattern.iterator;

/**
 * @author tancy
 * @description description
 * @date 2019/3/13 19:30
 **/
public class DinerMenuItr implements Itr {
    MenuItem[] menuItems;
    int position = 0;

    public DinerMenuItr(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public Object next() {
        return menuItems[position++];
    }

    @Override
    public boolean hasNext() {
        if (position < menuItems.length && menuItems[position] != null){
            return true;
        }
        return false;
    }

}
