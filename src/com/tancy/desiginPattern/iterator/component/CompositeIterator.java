package com.tancy.desiginPattern.iterator.component;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author tc
 * 2019/4/21 12:45
 * @description description
 */
public class CompositeIterator implements Iterator {

    Stack<Iterator> stack = new Stack();

    public CompositeIterator(Iterator iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()){
            return false;
        } else {
            Iterator itr = stack.peek();
            if (itr.hasNext()){
                return true;
            } else {
                stack.pop();
                return hasNext();
            }
        }
    }

    @Override
    public Object next() {
        if (hasNext()){
            Iterator itr = stack.peek();
            MenuComponent menuComponent = (MenuComponent) itr.next();
            System.out.println(menuComponent+"--"+menuComponent.getName());
            if (menuComponent instanceof Menu){
                stack.push(menuComponent.createIterator());
            }
            return menuComponent;
        }
        return null;
    }


}
