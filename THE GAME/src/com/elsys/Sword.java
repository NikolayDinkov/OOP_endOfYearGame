package com.elsys;

public class Sword extends Item implements Usable, Weapon{
    int dmg;

    Sword(String name, int dmg) {
        super(name, false);
        this.dmg = dmg;
    }

    @Override
    public void use(Entity player, Map map) {

    }
}
