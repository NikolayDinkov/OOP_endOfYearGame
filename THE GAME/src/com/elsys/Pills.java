package com.elsys;

public abstract class Pills extends Item implements Consumable{
    int power;
    int bad_effect;

    Pills(String name, int power, int bad_effect) {
        super(name, false);
        this.power = power;
        this.bad_effect = bad_effect;
    }
}
