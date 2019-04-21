package com.tancy.desiginPattern.iterator.component;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author tancy
 * @description description
 * @date 2019/3/29 19:05
 **/
public class Menu extends MenuComponent {
    private String name;
    private String description;
    ArrayList<MenuComponent> componentList = new ArrayList<>();


    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        componentList.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        super.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return componentList.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void print() {
        System.out.println("Menu{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", componentList=" + componentList +
                '}');
        Iterator<MenuComponent> itr = componentList.iterator();
        while (itr.hasNext()){
            MenuComponent mc = itr.next();
            mc.print();
        }
    }

    @Override
    public Iterator createIterator() {
        return new CompositeIterator(componentList.iterator());
    }

    @Override
    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }
}
