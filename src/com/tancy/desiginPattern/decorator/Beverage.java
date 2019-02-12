package com.tancy.desiginPattern.decorator;

public abstract class Beverage {
    private StringBuffer des;
    public static final float CUPSIZE_TALL=0.10f;
    public static final float CUPSIZE_GRAND=0.15f;
    public static final float CUPSIZE_VENTI=0.20f;
    private float size;

    public Beverage() {
        this.des=new StringBuffer();
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public abstract float getCupSize();

    public abstract void setCupSize();

    public abstract String getDescription();

    public abstract float cost();

    public String getDes() {
        return des.toString();
    }

    public void setDes(String des) {
        this.des.append(des);
    }
}
