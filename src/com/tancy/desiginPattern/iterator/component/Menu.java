package com.tancy.desiginPattern.iterator.component;


import java.util.List;

/**
 * @author tancy
 * @description description
 * @date 2019/3/29 19:05
 **/
public class Menu extends MenuComponent {
    private String name;
    private String description;
    List<MenuComponent> componentList;

    public Menu(List<MenuComponent> componentList) {
        this.componentList = componentList;
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
        for (MenuComponent menuComponent : componentList) {
            menuComponent.print();
        }
    }

}
