package com.elsys;

public abstract class Item implements GameObject{
    protected final String name;
    protected boolean picked;
    protected boolean collision;

    Item(String name, boolean collision) {
        this.name = name;
        this.picked = false;
        this.collision = collision;
    }


}