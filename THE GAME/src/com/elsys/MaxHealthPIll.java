package com.elsys;

public class MaxHealthPIll extends Pills implements Usable{
    int bonus_health;

    MaxHealthPIll(int power, int bad_effect) {
        super("MaxHealthPill", power, bad_effect);
        bonus_health = ((3 * power) - bad_effect);
    }

    @Override
    public void use(Entity player, THE_Map map) {

    }
}
