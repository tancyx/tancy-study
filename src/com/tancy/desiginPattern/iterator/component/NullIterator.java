package com.tancy.desiginPattern.iterator.component;

import java.util.Iterator;

/**
 * @author tc
 * 2019/4/21 13:34
 * @description 空迭代器，统一菜单和菜单项的处理，保持透明性
 */
public class NullIterator implements Iterator {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
