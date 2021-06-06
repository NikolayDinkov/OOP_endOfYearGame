package com.elsys;

public class RegenPill extends Pills implements Usable{
    int regen;

    RegenPill(int power, int bad_effect) {
        super("RegenPill", power, bad_effect);
        regen = power - bad_effect;
    }

    @Override
    public void use(Entity player, THE_Map map) {

    }
}
