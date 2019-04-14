package com.tancy.io.stream;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author tc
 * 2019/4/6 17:12
 * @description description
 */
public class SerializableObj implements Serializable {

    private String name;
    private int age;
    private int level;
    private BigDecimal money;

    public SerializableObj() {
    }

    public SerializableObj(String name, int age, int level, BigDecimal money) {
        this.name = name;
        this.age = age;
        this.level = level;
        this.money = money;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "SerializableObj{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", level=" + level +
                ", money=" + money +
                '}';
    }
}
