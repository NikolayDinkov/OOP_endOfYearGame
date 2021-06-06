package com.elsys;

public class PowerPill extends Pills implements Usable{
    int more_damage;

    PowerPill(int power, int bad_effect) {
        super("PowerPill", power, bad_effect);
        more_damage = 3 * power - bad_effect;
    }

    @Override
    public void use(Entity player, THE_Map map) {

    }
}
