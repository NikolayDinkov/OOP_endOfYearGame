package com.elsys;

public class Pills extends Item{
    int power;
    int efficient;

    Pills(String name, int power, int efficient) {
        super(name, false);
        this.power = power;
        this.efficient = efficient;
    }
}
