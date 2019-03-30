package com.tancy.desiginPattern.iterator;

import java.util.ArrayList;

/**
 * @author tancy
 * @description description
 * @date 2019/3/13 19:28
 **/
public class PancakeHouseMenuItr implements Itr {
    ArrayList menuItems;
    int position = 0;

    public PancakeHouseMenuItr(ArrayList menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public Object next() {
        return menuItems.get(position++);
    }

    @Override
    public boolean hasNext() {
        if (position < menuItems.size()){
            return true;
        }
        return false;
    }
}
